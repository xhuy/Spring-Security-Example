package com.example.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.bean.LoginBean;
import com.example.pojo.User;
import com.example.service.UserService;

@Controller
public class WebController {

	@Autowired
	private ApplicationContext appContext;

	// Creacion de vista desde nodo raiz y redirigido a index
	@RequestMapping(value = { "", "/index" })
	public ModelAndView getFromWelcomeFile() {
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}

	// Creacion de vista desde index
	@RequestMapping(value = "/login")
	public ModelAndView login(
			@RequestParam(value = "user", required = false) String username,
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout,
			HttpServletRequest request) {

		ModelAndView mv = new ModelAndView();

		if (error != null) {
			mv.addObject(
					"error",
					getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION",
							error));
			mv.setViewName("login");
		}

		if (logout != null) {
			mv.addObject("msg", "You've been logged out successfully.");
			mv.setViewName("login");
		}

		if (mv.hasView()) {
			return mv;
		}

		mv.setViewName("login");

		return mv;
	}

	@RequestMapping(value = "/controlPanel")
	public ModelAndView getFromControlPanel() {

		ModelAndView mv = new ModelAndView("controlPanel");
		return mv;

	}

	@RequestMapping(value = "/logSuccess")
	public ModelAndView loginSuccess() {

		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetails = (UserDetails) SecurityContextHolder
					.getContext().getAuthentication().getPrincipal();
			
			LoginBean loginBean = appContext.getBean(LoginBean.class);
			
			loginBean.setUser(userDetails.getUsername());
			loginBean.setLogeed(true);
			
		}

		ModelAndView mv = new ModelAndView("redirect:controlPanel");
		return mv;

	}

	// Creacion de vista desde nodo raiz y redirigido a index
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logoutPage(HttpServletRequest request,
			HttpServletResponse response) {

		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}

		appContext.getBean(LoginBean.class).init();

		ModelAndView mv = new ModelAndView("redirect:login?logout");
		return mv;
	}

	// Creacion de vista desde nodo raiz y redirigido a index
	@RequestMapping(value = "/register")
	public ModelAndView getFromRegister() {
		ModelAndView mv = new ModelAndView("register");
		return mv;
	}

	// Creacion de vista desde nodo raiz y redirigido a index
	@RequestMapping(value = "/registerNewUserExtranet", method = RequestMethod.POST)
	public ModelAndView createNewUser(
			@RequestParam(value = "newUser", required = true) String username,
			@RequestParam(value = "newPdw", required = true) String password) {

 		UserService userService = appContext.getBean(UserService.class);

		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setEnable(true);
		user.setRole("ROLE_USER");

		userService.create(user);

		ModelAndView mv = new ModelAndView("redirect:index");
		return mv;
	}

	@RequestMapping(value = { "/403" })
	public ModelAndView errorPage403() {
		ModelAndView mv = new ModelAndView("403");
		return mv;
	}

	// Utils

	private String getErrorMessage(HttpServletRequest request, String key,
			String error) {

		Exception exception = (Exception) request.getSession()
				.getAttribute(key);

		if (error.compareTo("2") == 0) {
			return "You need to be logeed to access the previuos page";
		}

		String errorMessage = "";
		if (exception instanceof BadCredentialsException) {
			errorMessage = "Invalid username and password!";
		} else if (exception instanceof LockedException) {
			errorMessage = exception.getMessage();
		} else {
			errorMessage = "Invalid username and password!";
		}

		return errorMessage;
	}

}

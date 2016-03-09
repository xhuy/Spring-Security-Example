package com.example.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class LoginBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6857807910143931867L;

	public LoginBean() {
		this.logeed = false;
		this.user = "";
	}

	private boolean logeed;

	private String user;

	public boolean isLogeed() {
		return logeed;
	}

	public void setLogeed(boolean logeed) {
		this.logeed = logeed;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	
	@PostConstruct
	public void init(){
		this.logeed = false;
		this.user = "";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoginBean other = (LoginBean) obj;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

}

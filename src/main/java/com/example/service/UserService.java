package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.UserModel;
import com.example.pojo.User;

@Service
public class UserService {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Transactional
	public User findByPrimaryKey(int id){
		return UserModel.findByPrimaryKey(id);
	}
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public int create(User user){
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return UserModel.create(user);
	}
	
	@Transactional(readOnly = false)
	public void update(User user){
		UserModel.update(user);
	}
	
	@Transactional(readOnly = false)
	public void delete(User user){
		UserModel.delete(user);
	}
	
	@Transactional
	public User findByUsername(String username){
		return UserModel.findByUsername(username);
	}
	
	
}

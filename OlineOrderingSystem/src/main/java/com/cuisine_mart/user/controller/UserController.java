package com.cuisine_mart.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cuisine_mart.user.domain.User;
import com.cuisine_mart.user.service.implementation.UserServiceImpl;

@Controller
public class UserController {
	@Autowired
	UserServiceImpl userServiceImpl;
	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String userSignUp(User user){
		userServiceImpl.signup(user);
		return "redirect :/";
	}

}

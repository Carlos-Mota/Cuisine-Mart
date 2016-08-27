package com.cuisine_mart.order.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cuisine_mart.order.service.IServiceContract.IFoodService;

@Controller
@RequestMapping("/")
public class homeController {
	@Autowired
	IFoodService foodService;
	
	@RequestMapping(method= RequestMethod.GET)
	public String homePage(Model model) {
		return "home";
	}
}

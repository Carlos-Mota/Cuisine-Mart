package com.cuisine_mart.order.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class homeController {
	@RequestMapping(method= RequestMethod.GET)
	public String homePage(Model model) {
		return "home";
	}
}

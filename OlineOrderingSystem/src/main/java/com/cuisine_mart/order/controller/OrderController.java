package com.cuisine_mart.order.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/order")
public class OrderController {
	@RequestMapping(value="/address",method= RequestMethod.GET)
	public String orderAddressPage(Model model) {
		return "orderAddress";
	}

}

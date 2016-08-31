package com.cuisine_mart.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cuisine_mart.user.domain.Address;
import com.cuisine_mart.user.domain.User;
import com.cuisine_mart.user.service.IServiceContract.IAddressService;
import com.cuisine_mart.user.service.IServiceContract.IPersonService;

@Controller
@RequestMapping(value="/order")
public class OrderController {
	
	@Autowired 
	IPersonService personService;
	
	@RequestMapping(value="/address",method= RequestMethod.GET)
	public String orderAddressPage(Model model) {
/*		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<Address> address = user.getPerson().getAddress();
		model.addAttribute("Address", address);*/
		return "orderAddress";
	}

}

package com.cuisine_mart.order.controller;

import java.util.Date;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.security.core.userdetails.User;

import com.cuisine_mart.order.domain.FoodOrder;
import com.cuisine_mart.order.service.IServiceContract.IOrderService;
import com.cuisine_mart.user.domain.Address;
import com.cuisine_mart.user.domain.Person;
import com.cuisine_mart.user.service.IServiceContract.IAddressService;
import com.cuisine_mart.user.service.IServiceContract.IPersonService;

@Controller
@RequestMapping(value="/order")
public class OrderController {
	
	@Autowired 
	IPersonService personService;
	@Autowired
	IAddressService addressService;
	
	@Autowired
	IOrderService orderService;
	
	@RequestMapping(value="/address",method= RequestMethod.GET)
	public String orderAddressPage(Model model) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = user.getUsername();
		Person person = personService.findPersonByEmail(username);
		model.addAttribute("Address", person.getAddress());
		model.addAttribute("OrderAddress",new Address());
		return "orderAddress";
	}
	
	@RequestMapping(value="/address",method=RequestMethod.POST)
	public String processOrder(@RequestParam String HiddenAddressId,@ModelAttribute("OrderAddress") Address address,Model model) {
		if(HiddenAddressId.equals("0")) {
			addressService.saveAddress(address);
		}
		else {
			//FoodOrder order = new FoodOrder();
			//orderService.create(order)
		}
		return"redirect:/ThankyouShopping";
	}

}

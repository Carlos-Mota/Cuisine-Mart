package com.cuisine_mart.order.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
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

import com.cuisine_mart.order.domain.Cart;
import com.cuisine_mart.order.domain.CartItem;
import com.cuisine_mart.order.domain.FoodOrder;
import com.cuisine_mart.order.domain.OrderDetail;
import com.cuisine_mart.order.service.IServiceContract.ICartService;
import com.cuisine_mart.order.service.IServiceContract.IOrderService;
import com.cuisine_mart.user.domain.Address;
import com.cuisine_mart.user.domain.Person;
import com.cuisine_mart.user.service.IServiceContract.IAddressService;
import com.cuisine_mart.user.service.IServiceContract.IPersonService;
import com.cuisine_mart.user.service.IServiceContract.IUserService;

@Controller
@RequestMapping(value="/order")
public class OrderController {
	
	@Autowired 
	IPersonService personService;
	@Autowired
	IAddressService addressService;
	
	@Autowired
	IUserService userService;
	
	@Autowired
	IOrderService orderService;
	
	@Autowired
	ICartService cartService;
	
	@RequestMapping(value="/address",method= RequestMethod.GET)
	public String orderAddressPage(Model model,HttpServletRequest request) {
		//User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		//String username = user.getUsername();
		//Person person = personService.findPersonByEmail(username);
//		model.addAttribute("Address", person.getAddress());
//		model.addAttribute("OrderAddress",new Address());
		Person person = (Person) request.getSession().getAttribute("person");
		model.addAttribute("Address", person.getAddress());
		model.addAttribute("OrderAddress",new Address());
		return "orderAddress";
	}
	
	@RequestMapping(value="/address",method=RequestMethod.POST)
	public String processOrder(@RequestParam String HiddenAddressId,@ModelAttribute("OrderAddress") Address address,Model model,HttpServletRequest request) {
		if(HiddenAddressId.equals("0")) {
			addressService.saveAddress(address);
			Person person = (Person) request.getSession().getAttribute("person");
			com.cuisine_mart.user.domain.User user = userService.getUserByUsername(person.getEmail());
			FoodOrder order = new FoodOrder(new Date(),null,user,address);
		}
		else {
			Person person = (Person) request.getSession().getAttribute("person");
			com.cuisine_mart.user.domain.User user = userService.getUserByUsername(person.getEmail());
			Address address1 = addressService.findAddressById(Integer.parseInt(HiddenAddressId));

			Cart cart  = cartService.read(request.getSession().getId());
			List<OrderDetail> orderItems = new ArrayList<>();
			Map<Long, CartItem> cartItem = cart.getCartItems();
			if(cartItem != null) {
				for(Map.Entry<Long, CartItem>entry:cartItem.entrySet()) {
					CartItem item = entry.getValue();
					orderItems.add(new OrderDetail(item.getFood(), item.getQuantity()));
				}
			}
			FoodOrder order = new FoodOrder(new Date(),orderItems,user,address1);
			orderService.create(order);
		}
		return"redirect:/ThankyouShopping";
	}

}

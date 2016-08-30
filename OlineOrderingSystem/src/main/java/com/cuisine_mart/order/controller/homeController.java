package com.cuisine_mart.order.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cuisine_mart.order.domain.Food;
import com.cuisine_mart.order.domain.FoodType;
import com.cuisine_mart.order.service.IServiceContract.IFoodService;
import com.cuisine_mart.restaurant.domain.Restaurant;
import com.cuisine_mart.restaurant.service.IServiceContract.IRestaurantService;

@Controller
public class homeController {
	@Autowired
	IFoodService foodService;
	
    @Autowired
    IRestaurantService restaurantService;
	
	@RequestMapping(value="/",method= RequestMethod.GET)
	public String homePage(Model model) {
		return "redirect:/user/dashboard";
	}
	
	@RequestMapping(value="/user/dashboard", method= RequestMethod.GET)
	public String userDashBoard(ModelMap modelMap) {
        List<Restaurant> restaurants = restaurantService.findAll();
        modelMap.addAttribute("restaurants",restaurants);

		return "userDashBoard";
	}
}

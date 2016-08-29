package com.cuisine_mart.order.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cuisine_mart.order.domain.Food;
import com.cuisine_mart.order.domain.FoodType;
import com.cuisine_mart.order.service.IServiceContract.IFoodService;

@Controller
@RequestMapping("/")
public class homeController {
	@Autowired
	IFoodService foodService;
	
	@RequestMapping(method= RequestMethod.GET)
	public String homePage(Model model) {
//		List<FoodType> foodType = new ArrayList<>();
//		foodType.add(FoodType.Pizza);
//		Food sample = new Food("Tuna Pizza", null, "Hot Pizza", null, 10.2);
//		Food addedFood = foodService.create(sample);
		return "home";
	}
}

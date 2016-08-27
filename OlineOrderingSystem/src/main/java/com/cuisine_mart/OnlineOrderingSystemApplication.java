package com.cuisine_mart;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.cuisine_mart.order.domain.Food;
import com.cuisine_mart.order.domain.FoodType;
import com.cuisine_mart.order.service.IServiceContract.IFoodService;

@SpringBootApplication
@ComponentScan(basePackages="com.cuisine_mart.*")
@EnableAutoConfiguration
public class OnlineOrderingSystemApplication {
	@Autowired
	private static IFoodService foodservice;
	
	public static void main(String[] args) {
		SpringApplication.run(OnlineOrderingSystemApplication.class, args);
		//IFoodService foodservice = new FoodServiceImpl();
		// Just For Test
		List<FoodType> foodType = new ArrayList<>();
		foodType.add(FoodType.Pizza);
		Food sample = new Food("Tuna Pizza", foodType, "Hot Pizza", null, 10.2);
		foodservice.create(sample);
	}
	
}

package com.cuisine_mart;

import com.cuisine_mart.restaurant.service.implementation.RestaurantServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OnlineOrderingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineOrderingSystemApplication.class, args);
        RestaurantServiceImpl restaurantService = new RestaurantServiceImpl();
        restaurantService.create();
	}

}

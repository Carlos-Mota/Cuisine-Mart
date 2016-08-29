package com.cuisine_mart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.cuisine_mart.order.domain.Food;
import com.cuisine_mart.order.domain.FoodType;
import com.cuisine_mart.order.service.IServiceContract.IFoodService;
import com.cuisine_mart.restaurant.dao.IDaoContract.IRestaurantDao;
import com.cuisine_mart.restaurant.domain.Restaurant;
import com.cuisine_mart.user.domain.Address;

@SpringBootApplication
@ComponentScan(basePackages="com.cuisine_mart.*")
@EnableAutoConfiguration
public class OnlineOrderingSystemApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(OnlineOrderingSystemApplication.class, args);

	}
	
	/*@Bean
    public CommandLineRunner demo(IRestaurantDao restaurantDao) {
        return (args) -> {
        	Restaurant restaurant1 = new Restaurant();
        	
            Address address1 = new Address();
            address1.setCity("Fairfield");
            address1.setState("IA");
            address1.setZip("57559");
            address1.setStreet("1000 N, 4th street");

            Address address2 = new Address();
            address2.setCity("Fairfield");
            address2.setState("IA");
            address2.setZip("57559");
            address2.setStreet("1000 N, 3rd street");

//            Food food1 = new Food("Pepper Pizza",FoodType.Pizza,"Pizza with pepper",null,20);
//
//            Food food2 = new Food("QQ Pepper Pizza",FoodType.Pizza,"QQQQ Pizza with pepper",null,30);
//
//            Menu menu = new Menu();
//            menu.setName("Menu First");
//            menu.setRestaurant(restaurant1);
//            menu.setFood(Arrays.asList(food1));
//
//            Menu menu1 = new Menu();
//            menu.setName("Menu First");
//            menu.setRestaurant(restaurant1);
//            menu.setFood(Arrays.asList(food2));

            restaurant1 = new Restaurant();
            restaurant1.setDescription("This is a nice restaurant which serves variety of foods");
            restaurant1.setName("F-one");
            restaurant1.setAddressList(Arrays.asList(address1,address2));
//            restaurant1.setMenus(Arrays.asList(menu,menu1));

            Restaurant restaurant2 = new Restaurant();
            restaurant2.setDescription("Best restaurant in the town");
            restaurant2.setName("F-two");
//            restaurant2.setAddressList(Arrays.asList(address1,address2));

            Restaurant restaurant3 = new Restaurant();
            restaurant3.setDescription("Your best food is available here");
            restaurant3.setName("F-three");
//            restaurant3.setAddressList(Arrays.asList(address1,address2));

            Restaurant restaurant4 = new Restaurant();
            restaurant4.setDescription("No other restaurant is like this one");
            restaurant4.setName("F-four");
//            restaurant4.setAddressList(Arrays.asList(address1,address2));

            restaurantDao.save(restaurant1);
            restaurantDao.save(restaurant2);
            restaurantDao.save(restaurant3);
            restaurantDao.save(restaurant4);

        };
    }*/
}

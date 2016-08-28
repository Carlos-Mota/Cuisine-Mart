package com.cuisine_mart.restaurant.service.implementation;

import com.cuisine_mart.restaurant.domain.CuisineCategory;
import com.cuisine_mart.restaurant.domain.Menu;
import com.cuisine_mart.restaurant.domain.Restaurant;
import com.cuisine_mart.restaurant.service.IServiceContract.IRestaurantService;
import com.cuisine_mart.user.domain.Address;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

/**
 * Created by Rajiv on 8/28/2016.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
public class RestaurantServiceImplTest {
    @Autowired
    IRestaurantService restaurantService;

    Restaurant restaurant;
    Restaurant restaurant1;

    @Before
    public void setup(){
        CuisineCategory cuisineCategory = initCuisine();
        cuisineCategory.setRestaurant(restaurant);
        Menu menu = initMenu();

        restaurant = new Restaurant();
        restaurant.setName("Pizza Hut");
        restaurant.setDescription("can get different pizzass");
        restaurant.setCuisineCategory(cuisineCategory);
//        restaurant.setAddressList(Arrays.asList(initAddress()));
        menu.setRestaurant(restaurant);
        restaurant.setMenus(Arrays.asList(menu));

        restaurant1 = new Restaurant();
        restaurant.setName("Pizza Ranch");
        restaurant.setDescription("can get chicken pizza");
        cuisineCategory.setRestaurant(restaurant);
        restaurant.setCuisineCategory(cuisineCategory);
//        restaurant.setAddressList(Arrays.asList(initAddress()));
        menu.setRestaurant(restaurant);
        restaurant.setMenus(Arrays.asList(menu));
    }

    public Address initAddress(){
        Address address = new Address();
        address.setState("IA");
        address.setStreet("1000 N, 4th Street");
        address.setZip("52557");
        address.setCity("Fairfield");
        return address;
    }

    public CuisineCategory initCuisine(){
        CuisineCategory cuisineCategory = new CuisineCategory();
        cuisineCategory.setDescription("italian local cuisine");
        cuisineCategory.setName("Italian");
//        cuisineCategory.setRestaurant();
        return cuisineCategory;
    }

    public Menu initMenu(){
        Menu menu = new Menu();
        menu.setName("Pizza");
        menu.setDescription("Pizza with tomato sauce");
        return menu;
    }

    @Test
    public void testSave() throws Exception {
        restaurantService.save(restaurant);
        Assert.assertEquals(restaurantService.get(Long.parseLong("1")).getName(),"Pizza Hut");
        Assert.assertEquals(restaurantService.get(Long.parseLong("2")).getCuisineCategory().getName(),"Italian");
    }

    @Test
    public void testDelete() throws Exception {
        restaurantService.save(restaurant);
        restaurantService.save(restaurant1);
        restaurantService.delete(Long.parseLong("2"));
        Assert.assertEquals(null,restaurantService.get(Long.parseLong("2")));
    }
}
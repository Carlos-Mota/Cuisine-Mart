package com.cuisine_mart.restaurant.service.implementation;

import com.cuisine_mart.restaurant.dao.IDaoContract.IRestaurantDao;
import com.cuisine_mart.restaurant.domain.Restaurant;
import com.cuisine_mart.restaurant.service.IServiceContract.IRestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Rajiv on 8/26/2016.
 */
@Service
public class RestaurantServiceImpl implements IRestaurantService {
    @Autowired
    IRestaurantDao restaurantDao;

    @Override
    public List<Restaurant> findRestaurantsByCuisine() {
        return null;
    }

    public void create(){
        System.out.println("restaurantDao = hello");
    }
}

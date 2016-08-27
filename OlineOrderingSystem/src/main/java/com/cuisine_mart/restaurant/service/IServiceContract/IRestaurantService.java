package com.cuisine_mart.restaurant.service.IServiceContract;

import com.cuisine_mart.restaurant.domain.Restaurant;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Rajiv on 8/26/2016.
 */
@Service
public interface IRestaurantService {
    List<Restaurant> findRestaurantsByCuisine();

}

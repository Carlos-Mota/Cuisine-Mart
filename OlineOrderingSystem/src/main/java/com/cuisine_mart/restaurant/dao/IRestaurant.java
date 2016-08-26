package com.cuisine_mart.restaurant.dao;

import com.cuisine_mart.restaurant.domain.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Rajiv on 8/26/2016.
 */
@Repository
public interface IRestaurant extends JpaRepository<Restaurant,Long> {
}

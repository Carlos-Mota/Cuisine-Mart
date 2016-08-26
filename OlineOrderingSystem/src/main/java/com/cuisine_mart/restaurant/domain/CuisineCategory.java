package com.cuisine_mart.restaurant.domain;

import javax.persistence.*;

/**
 * Created by Rajiv on 8/26/2016.
 */
@Entity
public class CuisineCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @OneToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

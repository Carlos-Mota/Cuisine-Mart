package com.cuisine_mart.restaurant.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Rajiv on 8/26/2016.
 */
@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String Address;

    @OneToOne
    @JoinColumn(name = "category_id")
    private CuisineCategory cuisineCategory;

    @OneToMany(mappedBy = "restaurant")
    private List<Menu> menus;

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CuisineCategory getCuisineCategory() {
        return cuisineCategory;
    }

    public void setCuisineCategory(CuisineCategory cuisineCategory) {
        this.cuisineCategory = cuisineCategory;
    }
}

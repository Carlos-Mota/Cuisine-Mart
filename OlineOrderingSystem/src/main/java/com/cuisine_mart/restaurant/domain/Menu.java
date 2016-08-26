package com.cuisine_mart.restaurant.domain;

import javax.persistence.*;

/**
 * Created by Rajiv on 8/26/2016.
 */
@Entity
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToOne
    private Restaurant restaurant;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

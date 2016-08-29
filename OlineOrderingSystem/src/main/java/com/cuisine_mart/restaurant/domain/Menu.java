package com.cuisine_mart.restaurant.domain;

import com.cuisine_mart.order.domain.Food;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Rajiv on 8/26/2016.
 */
@Entity
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long menuId;

    @Column(nullable = false)
    private String name;

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private List<Food> food;

    @ManyToOne(cascade = {CascadeType.ALL})
    private Restaurant restaurant;

    @Temporal(TemporalType.DATE)
    private Date dateCreated;

    @Temporal(TemporalType.DATE)
    private Date lastUpdated;

    public List<Food> getFood() {
        return food;
    }

    public void setFood(List<Food> food) {
        this.food = food;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public String getDescription() {
        return description;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Long getId(){return this.menuId; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Restaurant getRestaurant(){ return this.restaurant; }

    public void setRestaurant(Restaurant restaurant) {this.restaurant = restaurant; }
}

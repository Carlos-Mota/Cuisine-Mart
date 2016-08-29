package com.cuisine_mart.restaurant.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Rajiv on 8/26/2016.
 */
@Entity
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long menuId;

    private String name;

    public void setDescription(String description) {
        this.description = description;
    }

    private String description;

    @ManyToOne(cascade = {CascadeType.ALL})
    private Restaurant restaurant;

    @Temporal(TemporalType.DATE)
    private Date dateCreated;

    @Temporal(TemporalType.DATE)
    private Date lastUpdated;

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

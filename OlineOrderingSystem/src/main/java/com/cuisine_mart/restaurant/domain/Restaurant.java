package com.cuisine_mart.restaurant.domain;

import com.cuisine_mart.user.domain.Address;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Rajiv on 8/26/2016.
 */
@Entity
public class Restaurant {

    public Restaurant(){
        super();
    }

    public Restaurant(String name,String description,String image,List<Address> addressList,
                      CuisineCategory cuisineCategory,List<Menu> menus){
        this.name = name;
        this.description = description;
        this.image = image;
        this.addressList = addressList;
        this.cuisineCategory = cuisineCategory;
        this.menus = menus;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long restaurantId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    private String image;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Address> addressList;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", nullable = false)
    private CuisineCategory cuisineCategory;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Menu> menus;

    @Temporal(TemporalType.DATE)
    private Date dateCreated;

    @Temporal(TemporalType.DATE)
    private Date lastUpdated;

    public Date getDateCreated() {
        return dateCreated;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Long getId() {
        return restaurantId;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
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

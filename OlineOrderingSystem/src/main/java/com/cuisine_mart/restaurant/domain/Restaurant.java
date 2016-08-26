package com.cuisine_mart.restaurant.domain;

import com.cuisine_mart.user.domain.Address;

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

    @OneToMany(mappedBy = "addressId")
    private List<Address> addressList;

    @OneToOne
    @JoinColumn(name = "category_id")
    private CuisineCategory cuisineCategory;

    @OneToMany(mappedBy = "restaurant")
    private List<Menu> menus;

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

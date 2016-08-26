package com.cuisine_mart.restaurant.dao;

import com.cuisine_mart.restaurant.domain.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Rajiv on 8/26/2016.
 */
@Repository
public interface IMenu extends JpaRepository<Menu,Long> {
}

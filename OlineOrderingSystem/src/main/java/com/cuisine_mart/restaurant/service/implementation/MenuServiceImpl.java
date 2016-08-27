package com.cuisine_mart.restaurant.service.implementation;

import com.cuisine_mart.restaurant.dao.IDaoContract.IMenuDao;
import com.cuisine_mart.restaurant.service.IServiceContract.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Rajiv on 8/26/2016.
 */
@Service
public class MenuServiceImpl implements IMenuService {
    @Autowired
    IMenuDao iMenuDao;

    public void test(){
    }
}

package com.cuisine_mart.order.service.Implementation;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cuisine_mart.order.dao.IDaoContract.IFoodDao;
import com.cuisine_mart.order.domain.Food;
import com.cuisine_mart.order.exception.FoodNotFound;
import com.cuisine_mart.order.service.IServiceContract.IFoodService;

@Service
public class FoodServiceImpl implements IFoodService {
	@Autowired 
	IFoodDao foodDao;

	@Override
	@Transactional
	public Food create(Food food) {
		return foodDao.save(food);
	}

	@Override
	public void update(Food food) throws FoodNotFound {
		
		
	}

	@Override
	public void delete(int foodId) throws FoodNotFound {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Food> findByName(String name) throws FoodNotFound {
		return foodDao.findFoodByName(name);
	}

	@Override
	public List<Food> findByType(String type) throws FoodNotFound {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Food> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Food findById(int id) throws FoodNotFound {
		// TODO Auto-generated method stub
		return null;
	}
	

}

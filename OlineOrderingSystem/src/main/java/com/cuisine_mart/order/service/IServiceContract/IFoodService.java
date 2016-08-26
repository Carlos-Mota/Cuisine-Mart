package com.cuisine_mart.order.service.IServiceContract;

import java.util.List;

import com.cuisine_mart.order.domain.Food;
import com.cuisine_mart.order.exception.FoodNotFound;

public interface IFoodService {
	public Food create(Food food);
	public void update(Food food) throws FoodNotFound;
	public void delete(int foodId) throws FoodNotFound;
	public List<Food> findByName(String name) throws FoodNotFound;
	public List<Food> findByType(String type) throws FoodNotFound;
	public List<Food> findAll();
	public Food findById(int id) throws FoodNotFound;
}

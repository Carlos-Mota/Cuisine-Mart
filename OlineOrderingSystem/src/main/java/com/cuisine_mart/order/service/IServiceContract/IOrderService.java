package com.cuisine_mart.order.service.IServiceContract;

import java.util.Date;
import java.util.List;


import com.cuisine_mart.order.domain.FoodOrder;
import com.cuisine_mart.order.exception.OrderNotFound;

public interface IOrderService {
	public FoodOrder create(FoodOrder order);
	public void update(FoodOrder order) throws OrderNotFound;
	public void delete(int orderId) throws OrderNotFound;
	public List<FoodOrder> findByDate(Date date) throws OrderNotFound;
	public List<FoodOrder> findByType(String type) throws OrderNotFound;
	public List<FoodOrder> findAll();
	public FoodOrder findById(int id) throws OrderNotFound;
	public List<FoodOrder> findOrderByUser(int userId) throws OrderNotFound;
}

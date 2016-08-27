package com.cuisine_mart.order.service.IServiceContract;

import java.util.Date;
import java.util.List;


import com.cuisine_mart.order.domain.Order;
import com.cuisine_mart.order.exception.OrderNotFound;

public interface IOrderService {
	public Order create(Order order);
	public void update(Order order) throws OrderNotFound;
	public void delete(int orderId) throws OrderNotFound;
	public List<Order> findByDate(Date date) throws OrderNotFound;
	public List<Order> findByType(String type) throws OrderNotFound;
	public List<Order> findAll();
	public Order findById(int id) throws OrderNotFound;
}

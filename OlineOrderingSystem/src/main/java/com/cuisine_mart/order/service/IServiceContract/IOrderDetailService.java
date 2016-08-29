package com.cuisine_mart.order.service.IServiceContract;

import java.util.Date;
import java.util.List;

import com.cuisine_mart.order.domain.FoodOrder;
import com.cuisine_mart.order.domain.OrderDetail;
import com.cuisine_mart.order.exception.OrderNotFound;

public interface IOrderDetailService {
	public OrderDetail create(OrderDetail orderDetail);
	public void delete(int orderDetailId) throws OrderNotFound;
	public List<OrderDetail> findByDate(Date date) throws OrderNotFound;
	public List<OrderDetail> findByType(String type) throws OrderNotFound;
	public List<OrderDetail> findAll();
	public OrderDetail findById(int id) throws OrderNotFound;
	public List<OrderDetail> findOrderDetailByOrderId(int orderId) throws OrderNotFound;
}

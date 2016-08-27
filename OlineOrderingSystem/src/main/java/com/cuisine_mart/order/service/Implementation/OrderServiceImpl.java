package com.cuisine_mart.order.service.Implementation;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cuisine_mart.order.domain.Order;
import com.cuisine_mart.order.exception.OrderNotFound;
import com.cuisine_mart.order.service.IServiceContract.IOrderService;

@Service
public class OrderServiceImpl implements IOrderService {

	@Override
	public Order create(Order order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Order order) throws OrderNotFound {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int orderId) throws OrderNotFound {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Order> findByDate(Date date) throws OrderNotFound {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> findByType(String type) throws OrderNotFound {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order findById(int id) throws OrderNotFound {
		// TODO Auto-generated method stub
		return null;
	}

}

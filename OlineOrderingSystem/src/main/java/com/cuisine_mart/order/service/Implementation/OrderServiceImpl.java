package com.cuisine_mart.order.service.Implementation;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cuisine_mart.order.domain.FoodOrder;
import com.cuisine_mart.order.exception.OrderNotFound;
import com.cuisine_mart.order.service.IServiceContract.IOrderService;

@Service
public class OrderServiceImpl implements IOrderService {

	@Override
	public FoodOrder create(FoodOrder order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(FoodOrder order) throws OrderNotFound {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int orderId) throws OrderNotFound {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<FoodOrder> findByDate(Date date) throws OrderNotFound {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FoodOrder> findByType(String type) throws OrderNotFound {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FoodOrder> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FoodOrder findById(int id) throws OrderNotFound {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FoodOrder> findOrderByUser(int userId) throws OrderNotFound {
		// TODO Auto-generated method stub
		return null;
	}

}

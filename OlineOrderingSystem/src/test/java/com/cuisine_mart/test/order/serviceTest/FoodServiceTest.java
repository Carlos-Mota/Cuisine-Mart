package com.cuisine_mart.test.order.serviceTest;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cuisine_mart.order.domain.Food;
import com.cuisine_mart.order.domain.FoodType;
import com.cuisine_mart.order.service.IServiceContract.IFoodService;

import junit.framework.Assert;



public class FoodServiceTest {
	@Autowired
	IFoodService foodService;

	@Test
	public void testCreate() {
		
		List<FoodType> foodType = new ArrayList<>();
		foodType.add(FoodType.Pizza);
		Food sample = new Food("Tuna Pizza", foodType, "Hot Pizza", null, 10.2);
		Food addedFood = foodService.create(sample);
		Assert.assertEquals("Tuna Pizza", addedFood.getName());
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByName() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByType() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindById() {
		fail("Not yet implemented");
	}

}

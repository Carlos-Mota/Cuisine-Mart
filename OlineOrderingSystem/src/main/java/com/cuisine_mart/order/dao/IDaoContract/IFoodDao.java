package com.cuisine_mart.order.dao.IDaoContract;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.integration.util.UpperBound;
import org.springframework.stereotype.Repository;

import com.cuisine_mart.order.domain.Food;

@Repository
public interface IFoodDao extends JpaRepository<Food, Long> {
	@Query("SELECT f FROM Food f WHERE Upper(f.name) =:name")
	public List<Food> findFoodByName(String name);
}

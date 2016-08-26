package com.cuisine_mart.order.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Food {
	@Id
	@GeneratedValue
	private int foodId;
	private String name;
	@Enumerated
	private List<FoodType> type;
	private String description;
	private byte[] image;
	
	public Food() {
		super();
	}

	public Food(String name, List<FoodType> type, String description, byte[] image) {
		super();
		this.name = name;
		this.type = type;
		this.description = description;
		this.image = image;
	}

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<FoodType> getType() {
		return type;
	}

	public void setType(List<FoodType> type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
	
	
}

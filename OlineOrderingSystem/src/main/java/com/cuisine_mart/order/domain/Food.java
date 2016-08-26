package com.cuisine_mart.order.domain;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Food {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	@ElementCollection
	private List<FoodType> type;
	private String description;
	private byte[] image;
	private double price;
	
	public Food() {
		super();
	}

	public Food(String name, List<FoodType> type, String description, byte[] image, double price) {
		super();
		this.name = name;
		this.type = type;
		this.description = description;
		this.image = image;
		this.price=price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
}

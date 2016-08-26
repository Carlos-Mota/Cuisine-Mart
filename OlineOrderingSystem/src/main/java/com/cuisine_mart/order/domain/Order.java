package com.cuisine_mart.order.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cuisine_mart.user.domain.Address;
import com.cuisine_mart.user.domain.User;

@Entity
@Table
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Temporal(TemporalType.DATE)
	private Date orderDate;
	@OneToMany(mappedBy="order")
	private List<OrderDetail> orderDetail = new ArrayList<>();
	@ManyToOne
	@JoinColumn
	private User user;
	@OneToOne
	@JoinColumn(name="addressId")
	private Address address;
	
	
	public Order() {
		super();
	}
	
	public Order(Date orderDate, List<OrderDetail> orderDetail, User user, Address address) {
		super();
		this.orderDate = orderDate;
		this.orderDetail = orderDetail;
		this.user = user;
		this.address = address;
	}

	public Order(Date orderDate, List<OrderDetail> orderDetail) {
		super();
		this.orderDate = orderDate;
		this.orderDetail = orderDetail;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public List<OrderDetail> getOrderDetail() {
		return orderDetail;
	}
	public void setOrderDetail(List<OrderDetail> orderDetail) {
		this.orderDetail = orderDetail;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
}

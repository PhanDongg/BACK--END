package mock.project.backend.request;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Set;

import mock.project.backend.entities.Products;
import mock.project.backend.entities.Status;
import mock.project.backend.entities.Users;

public class OrderDTO {
	
	private Integer orderId;
	private LocalDate orderDate;
	private int quantity;
	private double totalPrice;
	private Products product;
	private Users user;
	private Status status;
	
	public OrderDTO() {
		super();
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Products getProduct() {
		return product;
	}
	public void setProduct(Products product) {
		this.product = product;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
}

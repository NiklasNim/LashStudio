package model;

import java.time.LocalDate;

public class Order {
	private LocalDate orderDate;
	private int orderId;

	public Order(LocalDate orderDate, int orderId) {
		this.orderDate = orderDate;
		this.orderId = orderId;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
}
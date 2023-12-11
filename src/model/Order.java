package model;

import java.util.Date;

public class Order {
	private Date orderDate;
	private int orderId;

	public Order(Date orderDate, int orderId) {
		this.orderDate = orderDate;
		this.orderId = orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
}
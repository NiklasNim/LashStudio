package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {
	private LocalDate orderDate;
	private int orderId;
	private List<OrderLine> orderLines;

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
	
	public ArrayList<OrderLine> getOrderLines() {
		return (ArrayList<OrderLine>) orderLines;
	}
}
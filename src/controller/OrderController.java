package controller;

import java.util.*;
import model.*;

public class OrderController {
	private List<Order> orders;

	public OrderController() {
		this.orders = new ArrayList<>();
	}

	public void createOrder(Date orderDate, int orderId) {
		Order order = new Order(orderDate, orderId);
		orders.add(order);
	}

	public List<Order> getAllOrders() {
		return orders;
	}

	public Order getOrderById(int orderId) {
		for (Order order : orders) {
			if (order.getOrderId() == orderId) {
				return order;
			}
			;
		}
		return null; // hvis ordren ikke bliver fundet
	}

	public void updateOrder(int orderId, Date newOrderDate) {
		Order order = getOrderById(orderId);
		if (order != null) {
			order.setOrderDate(newOrderDate);
		} else {
			System.out.println("Ordren blev ikke fundet");
		}
	}

	// Metode, der fjerner en order +
	public void removeOrder(int orderId) {
		Order order = getOrderById(orderId);
		if (order != null) {
			orders.remove(order);
		} else {
			System.out.println("Ordren blev ikke fundet"); // Ordren blev ikke fundet ved brug af orderId
		}
	}
}

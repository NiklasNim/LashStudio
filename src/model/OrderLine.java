package model;

import java.math.BigDecimal;


public class OrderLine {
	private Product product;
	private Order order;
	private int quantity; 
	private BigDecimal unitPrice;
	
	
	public OrderLine(Product product, Order order, int quantity, BigDecimal unitPrice) {
		this.product = product;
		this.order = order;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	
	
}

package model;

import java.math.BigDecimal;
import java.util.List;

public class BookingLine {
	private Service service;
	private int quantity; 
	private BigDecimal unitPrice;
	// private money unitMoney; 
	
	public BookingLine(Service service, int quantity, BigDecimal unitPrice) {
		
		this.service = service;
		this.quantity = quantity;
		this.unitPrice = unitPrice;

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
	
	public Service getService() {
		return service;
	}
}

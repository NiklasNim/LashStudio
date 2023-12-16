package model;

import java.math.BigDecimal;

public class BookingLine {
	private int bookingLineId;
	private Service service;
	private BigDecimal unitPrice;
	private int serviceId;
	private int scheduleId;

	
	public BookingLine(Service service, BigDecimal unitPrice) {
		
		this.service = service;
		this.unitPrice = unitPrice;
	}
	
	
	 public int getBookingLineId() {
	    return bookingLineId;
	 }
	 
	 public void setBookingLineId(int bookingLineId) {
	    this.bookingLineId = bookingLineId;
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
	
	public int getScheduleId() {
	    return scheduleId;
	}
	
	public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }
	  
	public int getServiceId() {
		return serviceId;
	}
	
	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
    }
}

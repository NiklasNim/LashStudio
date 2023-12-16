package model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Service {
	private int serviceId;
	private BigDecimal price;
	private String description;
	private String serviceType;
	private int locationId;


	public Service(int serviceId, BigDecimal price, String description, String serviceType, int locationId) {
		this.serviceId = serviceId;
		this.price = price;
		this.description = description;
		this.serviceType = serviceType;
		this.locationId = locationId;
	}


	public int getServiceId() {
		return serviceId;
	}


	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}


	public BigDecimal getPrice() {
		return price;
	}


	public void setPrice(BigDecimal price) {
		this.price = price;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getServiceType() {
		return serviceType;
	}


	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}


	public int getLocationId() {
		return locationId;
	}


	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	
	

}

package model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Service {
	private Location location;
	private int serviceId;
	private Timestamp timePeriod; // tjek lige
	private BigDecimal price; // tjek lige ud
	private String description;
	private String serviceType;

	public Service(int serviceId, Timestamp timePeriod, BigDecimal price, String description, String serviceType) {
		this.serviceId = serviceId;
		this.timePeriod = timePeriod;
		this.price = price;
		this.description = description;
		this.serviceType = serviceType;
	}

	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	public Timestamp getTimePeriod() {
		return timePeriod;
	}

	public void setTimePeriod(Timestamp timePeriod) {
		this.timePeriod = timePeriod;
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

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

}

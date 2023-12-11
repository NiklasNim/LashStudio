package model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Hair extends Service {

	private String gender;

	public Hair(int serviceId, Timestamp timePeriod, BigDecimal price, String description, String serviceType, String gender) {
		super(serviceId, timePeriod, price, description, serviceType);
		this.gender = gender;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}

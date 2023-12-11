package model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Hair extends Service {

	private String gender;

	public Hair(Timestamp timePeriod, BigDecimal price, String description, String serviceType, String gender) {
		super(timePeriod, price, description, serviceType);
		this.gender = gender;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}

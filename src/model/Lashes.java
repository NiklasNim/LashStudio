package model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Lashes extends Service {

	private String volume;

	public Lashes(int serviceId, Timestamp timePeriod, BigDecimal price, String description, String serviceType, String volume) {
		super(serviceId, timePeriod, price, description, serviceType);
		this.volume = volume;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}
}

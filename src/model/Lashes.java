package model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Lashes extends Service {

	private String volume;

	public Lashes(Timestamp timePeriod, BigDecimal price, String description, String serviceType, String volume) {
		super(timePeriod, price, description, serviceType);
		this.volume = volume;

	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}
}

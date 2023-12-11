package model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Nails extends Service {

	public boolean extension;

	public Nails(Timestamp timePeriod, BigDecimal price, String description, String serviceType, boolean extension) {
		super(timePeriod, price, description, serviceType);
		this.extension = extension;
	}

	public boolean getExtenesion() {
		return extension;
	}

	public void setExtension(boolean extension) {
		this.extension = extension;
	}
}

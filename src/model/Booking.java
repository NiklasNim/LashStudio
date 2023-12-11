package model;

import java.util.Date;

public class Booking {
	private Date bookingDate;
	private int bookingId;

	public Booking(Date bookingDate, int bookingId) {
		this.bookingDate = bookingDate;
		this.bookingId = bookingId;
	}

	public Date getBooking() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setOrderId(int bookingId) {
		this.bookingId = bookingId;
	}
}

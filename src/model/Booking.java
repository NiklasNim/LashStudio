package model;

import java.time.LocalDate;
import java.util.*;


public class Booking {
	private LocalDate bookingDate;
	private int bookingId;
	private List<BookingLine> booking;
	private Customer c;

	public Booking(LocalDate bookingDate, int bookingId, Customer c) {
		this.bookingDate = bookingDate;
		this.bookingId = bookingId;
		this.booking = new ArrayList<>();
		this.c = c;
	}


	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	
	public void addBooking(BookingLine b) {
		booking.add(b);
	}
	
	public void addCustomer(Customer c) {
		this.c = c;
	}
}

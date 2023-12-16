package model;

import java.time.LocalDate;
import java.util.*;


public class Booking {
	private LocalDate bookingDate;
	private List<BookingLine> bookingLines;

	private int customerId;

	public Booking(LocalDate bookingDate, int customerId) {
		this.bookingDate = bookingDate;
		this.bookingLines = new ArrayList<>();
		this.customerId = customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public int getCustomerId() {
		return customerId;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}
	
	public void addBookingLine(BookingLine bookingLine) {
		this.bookingLines.add(bookingLine);
	}
	
	public ArrayList<BookingLine> getBookingLines() {
		return (ArrayList<BookingLine>) bookingLines;
	}
	
}

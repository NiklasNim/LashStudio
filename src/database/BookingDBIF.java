package database;

import java.util.List;

import model.Booking;

public interface BookingDBIF {

	List<Booking> getBookings();

	int addBooking(Booking booking);

}

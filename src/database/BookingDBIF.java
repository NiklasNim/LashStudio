package database;
import model.Booking;
import model.BookingLine;

public interface BookingDBIF {
	void addBooking(Booking booking);
	
	void addBookingLine(BookingLine bookingLine, int bookingId);
}
package database;
import model.Booking;
import model.BookingLine;

public interface BookingDBIF {
	// Metode til at tilføje en booking til databasen
	void submitBooking(Booking booking); 
	
	// Metode der tilføjer en bookingline til databasen
	void addBookingLine(BookingLine bookingLine, int bookingId); 
}
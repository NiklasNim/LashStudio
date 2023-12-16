package test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import controller.BookingController;
import model.Booking;
import model.Customer;

import java.time.LocalDate;

public class TestBookingController {
    private BookingController bookingController;
    private Customer mockCustomer;
    private int bookingId;
    private LocalDate bookingDate;

    @Before
    public void setUp() {
        bookingController = new BookingController();
        
        mockCustomer = new Customer("Henrik", "Larsen", 2023024);
        
        bookingId = 1;

        bookingDate = LocalDate.now();
    }

    @Test
    public void testCreateBooking() {
        Booking booking = bookingController.createBooking(bookingDate, bookingId, mockCustomer);
        assertNotNull("Booking skal ikke være null", booking);
        assertEquals("Booking ID matcher ikke", bookingId, booking.getBookingId());
        assertEquals("Booking dato matcher ikke", bookingDate, booking.getBookingDate());
        assertEquals("Kunde matcher ikke", mockCustomer, booking.getCustomer());
    }
}
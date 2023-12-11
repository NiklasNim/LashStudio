package controller;
import java.util.ArrayList;
import java.util.List;
import database.BookingDBIF;
import model.Booking;
import model.Customer;
import model.Service;

public class BookingController {
	private BookingController bookingController;
	private CustomerController customerController;
	private BookingDBIF bookingDBIF;
	private List<Booking> bookings;
	private List<Customer> customers;

	public BookingController() {
		this.bookings = new ArrayList<>();
	}
	
	public List<Booking> getAllBookings() {
		return bookings;
	}
	
	public Customer findCustomerByPhone(int phone) {
		for (Customer customer : customers) {
			if (customer.getPhone() == phone) {
				return customer;
			}
		}
		return null;
	}
}
	}
	
	list all services
	
	

	addservicebyId
	
	
	findavailable services
	
	addservicedate
	
	
}

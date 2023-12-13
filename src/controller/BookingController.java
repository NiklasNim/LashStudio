package controller;
import java.util.ArrayList;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import database.*;
import model.*;



public class BookingController {
	private ServiceController serviceController;
	private CustomerController customerController;
	private BookingDBIF bookingDB;
	private CustomerDBIF customerDB;
	private BookingLineController bookingLine;
	private Booking booking;
	private ServiceDBIF serviceDB;


	public BookingController() {
		this.bookingDB = new BookingDB();
		this.bookingLine = new BookingLineController();
		this.serviceController = new ServiceController();
		this.customerController = new CustomerController();
		this.serviceDB = new ServiceDB();
	}
	
	
	public Booking createBooking(LocalDate bookingDate, int bookingId) {
		this.booking = new Booking(bookingDate, bookingId);
		return booking;
	}
	
	
	//skal laves færdigt - skal vi have bookingLineController??
	public void addBookingLine(Service service, int quantity, BigDecimal unitPrice) {
		this.bookingLine = new BookingLine(service, quantity, unitPrice);
	}
	
	
	
	public void addCustomerByPhone(int phone) {
		Customer c = customerController.findCustomerByPhone(phone);
		booking.addCustomer(c);	
	}
	
	
	
	public List<Services> findAllServiceDates(LocalDate date) {
		return serviceDB.findAllServiceDates(date);
	}
	
	
	
	public List<Booking> getAllBookings() {
		return bookingDB.getBookings();
	}
	
	
//		for (Customer customer : customers) {
//			if (customer.getPhone() == phone) {
//				return customer;
//			}
//		}
//		return null;
//	}

	
	
	list all services
	
	

	public void addServiceById(int serviceID) {
		
	}
	
	
	public void findAvailableTimeSlot(int serviceId) {
		return list<TimeSlot>;
	}
	
	addservicedate
	
	
}

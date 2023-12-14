package controller;
import java.util.ArrayList;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import database.*;
import model.*;



public class BookingController {
	private ServiceController serviceController;
	private CustomerController customerController;
	private BookingDBIF bookingDB;
	private CustomerDBIF customerDB;
	private BookingLine bookingLine;
	private Booking booking;
	private ServiceDBIF serviceDB;


	public BookingController() {
		this.bookingDB = new BookingDB();
		this.serviceController = new ServiceController();
		this.customerController = new CustomerController();
		this.serviceDB = new ServiceDB();
		//this.bookingLine = new BookingLine();
	}
	
	
	public Booking createBooking(LocalDate bookingDate, int bookingId, Customer customer) {
		this.booking = new Booking(bookingDate, bookingId, customer);
		return booking;
	}
	
	
	//skal laves færdigt - skal vi have bookingLineController??
	public void addBookingLine(Service service, int quantity, BigDecimal unitPrice) {
		this.bookingLine = new BookingLine(service, quantity, unitPrice);
	}
	
	
	
	public void findCustomerByPhone(int phone) {
		Customer c = customerController.findCustomerByPhone(phone);
		booking.addCustomer(c);	
	}
	
	public void addServiceById(int serviceId, int quantity, BigDecimal unitPrice) {
		Service s = serviceController.findServiceById(serviceId);
		addBookingLine(s, quantity, unitPrice);
	}
	
	
	public LocalDateTime findAvailableServiceDates(int serviceId) {
		return serviceDB.findAvailableServiceDates(serviceId);
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

	
	
	
	
	
	public void addservicedate() {
		
	}
	
	
}

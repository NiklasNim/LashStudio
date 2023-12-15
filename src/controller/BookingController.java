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
	private List<Schedule> scheduleList;
	private ScheduleDB scheduleDB;


	public BookingController() {
		this.bookingDB = new BookingDB();
		this.serviceController = new ServiceController();
		this.customerController = new CustomerController();
		this.serviceDB = new ServiceDB();
		//this.bookingLine = new BookingLine();
		this.scheduleList = serviceDB.getAllAvailableDates();
		this.scheduleDB = new ScheduleDB();
	}
	
	
	public Booking createBooking(LocalDate bookingDate, int bookingId, Customer customer) {
		this.booking = new Booking(bookingDate, bookingId, customer);
		return booking;
	}
	
	
	public void addBookingLine(Booking booking, Service service, int quantity, BigDecimal unitPrice) {
	    BookingLine newLine = new BookingLine(service, quantity, unitPrice);
	    booking.addBookingLine(newLine);
	}
	
	
<<<<<<< Updated upstream
	
	public void findCustomerByPhone(int phone) {
=======
	public void addCustomerByPhone(int phone) {
>>>>>>> Stashed changes
		Customer c = customerController.findCustomerByPhone(phone);
		booking.addCustomer(c);	
	}
	
	public void addServiceById(int serviceId, int quantity, BigDecimal unitPrice) {
		Service s = serviceController.findServiceById(serviceId);
		addBookingLine(booking, s, quantity, unitPrice);
	}
	
	
	public LocalDateTime findAvailableServiceDates(int serviceId) {
		return serviceDB.findAvailableServiceDates(serviceId);
	}
	
	public List<Booking> getAllBookings() {
		return bookingDB.getBookings();
	}
	
	
	private boolean canBook(int scheduleId) {
	    return scheduleList.stream().anyMatch(schedule -> schedule.getScheduleId() == scheduleId);
	}
	
	// skal ikke være en print senere i programmet men en kaste en exception
	public void attemptBooking(int scheduleId) {
	    if (canBook(scheduleId)) {
	        completeBooking(scheduleId);
	    } else {
	    
	        System.out.println("Det valgte tidsinterval er ikke længere tilgængeligt.");
	    }
	}

	//Kun hvis vi har god tid
	private void sendConfirmationToCustomer(Customer customer, Booking booking) {
	
	}
	
	
	private void completeBooking(int scheduleId) {
	    Schedule selectedSchedule = scheduleList.stream()
	                                .filter(schedule -> schedule.getScheduleId() == scheduleId)
	                                .findFirst()
	                                .orElse(null);

	    if (selectedSchedule != null && canBook(scheduleId)) {
	        
	        int serviceId = selectedSchedule.getServiceId();

	       
	        Service service = serviceController.findServiceById(serviceId);
	        BigDecimal unitPrice = service.getPrice();

	        //Skal vel ikke med længere
	        int quantity;

	        
	        BookingLine bookingLine = new BookingLine(service, quantity, unitPrice);
	        booking.addBookingLine(bookingLine);

	 
	        scheduleDB.markScheduleAsBooked(selectedSchedule);

	        bookingDB.addBooking(booking);

	    } else {
	        System.out.println("Kan ikke fuldføre bookingen, tidspunktet er ikke tilgængeligt.");
	    }
	}


	
}

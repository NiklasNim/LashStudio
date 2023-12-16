package controller;
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
		this.scheduleDB = new ScheduleDB();
		this.customerDB = new CustomerDB();
		this.serviceController = new ServiceController();
		this.customerController = new CustomerController();
		this.serviceDB = new ServiceDB();
		//this.bookingLine = new BookingLine();
		this.scheduleList = serviceDB.getAllAvailableDates();
		
	}
	
	
	public Booking createBooking(LocalDate bookingDate, Customer customer) {
		this.booking = new Booking(bookingDate, customer.getCustomerId());
		return booking;
	}
	
	
	public void addBookingLine(int scheduleId , Booking booking, Service service, BigDecimal unitPrice) {
	    // Opret en ny BookingLine med service og unitPrice
	    BookingLine newBookingLine = new BookingLine(service, unitPrice);

	    // Hent serviceId fra service-objektet
	    int serviceId = service.getServiceId();

	    // Sæt serviceId, bookingId, og scheduleId på den nye BookingLine
	    newBookingLine.setServiceId(serviceId);
	    newBookingLine.setScheduleId(scheduleId);

	    // Tilføj den nye BookingLine til booking
	    booking.addBookingLine(newBookingLine);
	}
	
	
	public Customer findCustomerByPhone(int phone) {
	    return customerController.findCustomerByPhone(phone);
	}

	public void addCustomerByPhone(int phone) {
	    Customer c = findCustomerByPhone(phone);
	    if (c != null) {
	        booking.setCustomerId(c.getCustomerId());
	    } else {
	        throw new IllegalArgumentException("Kunde med telefonnummer " + phone + " blev ikke fundet.");
	    }
	}

	
	public LocalDateTime findAvailableServiceDates(int serviceId) {
		return serviceDB.findAvailableServiceDates(serviceId);
	}
	
	public List<Booking> getAllBookings() {
		return bookingDB.getBookings();
	}
	
		

	private boolean canBook(int scheduleId) {
        List<Schedule> scheduleList = scheduleDB.getAllAvailableSchedules();
        return scheduleList.stream().anyMatch(schedule -> schedule.getScheduleId() == scheduleId);
	}


	public void makeBooking(LocalDate bookingDate, int phone, int scheduleId, List<Integer> serviceIds) {
        if (canBook(scheduleId)) {
              // Hent kunden fra databasen
            Customer customer = customerDB.findCustomerByPhone(phone);
            if (customer == null) {
                throw new RuntimeException("Kunde ikke fundet.");
            }

            // Opret en ny Booking
            Booking newBooking = createBooking(bookingDate, customer); 
            // Tilføj bookinglinjer til bookingen baseret på serviceIds
            for (Integer serviceId : serviceIds) {
                Service service = serviceController.findServiceById(serviceId);
                if (service != null) {
                    BigDecimal unitPrice = service.getPrice();
                    addBookingLine(scheduleId, newBooking, service, unitPrice);
                } else {
                    throw new RuntimeException("Service ikke fundet for ID: " + serviceId);
                }
            }

            // Gem bookingen i databasen
            int bookingId = bookingDB.addBooking(newBooking);
        } else {
            throw new RuntimeException("Tidsplanen er ikke tilgængelig for booking.");
        }
    }        
        
        
        
	
	private void completeBooking(int scheduleId) {
	    Schedule selectedSchedule = scheduleList.stream()
	                                .filter(schedule -> schedule.getScheduleId() == scheduleId)
	                                .findFirst()
	                                .orElse(null);

	    if (selectedSchedule != null && canBook(scheduleId)) {
	        
	        int serviceId = selectedSchedule.getScheduleId();
       
	        Service service = serviceController.findServiceById(serviceId);
	        BigDecimal unitPrice = service.getPrice();
        
	        BookingLine bookingLine = new BookingLine(service, unitPrice);
	        booking.addBookingLine(bookingLine);
 
	        scheduleDB.markScheduleAsBooked(selectedSchedule);

	        bookingDB.addBooking(booking);

	    } else {
	        System.out.println("Kan ikke fuldføre bookingen, tidspunktet er ikke tilgængeligt.");
	    }
	}
}

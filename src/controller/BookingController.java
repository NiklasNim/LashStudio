package controller;
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
	private Booking booking;
	private ScheduleDB scheduleDB;

	public BookingController() {
		this.bookingDB = new BookingDB();
		this.scheduleDB = new ScheduleDB();
		this.customerDB = new CustomerDB();
		this.serviceController = new ServiceController();
		this.customerController = new CustomerController();	
	}

	public void makeBooking(LocalDate bookingDate, int phone, int scheduleId, List<Integer> serviceIds) {
		if(!canBook(scheduleId)) {
			throw new RuntimeException("Tidsplanen er ikke tilgængelig for booking.");
		}
		
		Customer customer = customerDB.findCustomerByPhone(phone);
		if (customer == null) {
            throw new RuntimeException("Kunde ikke fundet.");
        }
      
        Booking newBooking = new Booking(bookingDate, customer.getCustomerId()); 
        for (Integer serviceId : serviceIds) {
            Service service = serviceController.findServiceById(serviceId);
            if (service != null) {
                BigDecimal unitPrice = service.getPrice();
                addBookingLine(scheduleId, newBooking, service, unitPrice);
            } else {
                throw new RuntimeException("Service ikke fundet for ID: " + serviceId);
            }
       }

        bookingDB.addBooking(newBooking);
    }  
	
	public void addBookingLine(int scheduleId , Booking booking, Service service, BigDecimal unitPrice) {
	    BookingLine newBookingLine = new BookingLine(service, unitPrice);

	    newBookingLine.setServiceId(service.getServiceId());
	    newBookingLine.setScheduleId(scheduleId);

	    booking.addBookingLine(newBookingLine);
	}
	
	
	private boolean canBook(int scheduleId) {
        List<Schedule> scheduleList = scheduleDB.getAllAvailableSchedules();
        return scheduleList.stream().anyMatch(schedule -> schedule.getScheduleId() == scheduleId);
	}
	
				
	public void addCustomerByPhone(int phone) {
	    Customer c = customerController.findCustomerByPhone(phone);
	    if (c != null) {
	        booking.setCustomerId(c.getCustomerId());
	    } else {
	        throw new IllegalArgumentException("Kunde med telefonnummer " + phone + " blev ikke fundet.");
	    }
	}
}
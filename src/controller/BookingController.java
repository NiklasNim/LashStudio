package controller;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import database.*;
import model.*;

public class BookingController {
	private ServiceController serviceController;
	private CustomerController customerController;
	private ScheduleController scheduleController;
	private BookingDB bookingDB;

	public BookingController() {
		this.serviceController = new ServiceController();
		this.customerController = new CustomerController();
		this.scheduleController = new ScheduleController();
		this.bookingDB = new BookingDB();
	}

	public void makeBooking(LocalDate bookingDate, int phone, int scheduleId, List<Integer> serviceIds) {
		if(!canBook(scheduleId)) {
			throw new RuntimeException("Tidsplanen er ikke tilgængelig for booking.");
		}
		
		Customer customer = customerController.findCustomerByPhone(phone);
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
	
	public void makeBooking(LocalDate bookingDate, int phone, int scheduleId, int serviceId) {
		List<Integer> serviceIds = new ArrayList<>();
        serviceIds.add(serviceId);
        makeBooking(bookingDate, phone, scheduleId, serviceIds);
	}
	
	public void addBookingLine(int scheduleId , Booking booking, Service service, BigDecimal unitPrice) {
	    BookingLine newBookingLine = new BookingLine(service, unitPrice);

	    newBookingLine.setServiceId(service.getServiceId());
	    newBookingLine.setScheduleId(scheduleId);

	    booking.addBookingLine(newBookingLine);
	}
		
	private boolean canBook(int scheduleId) {
        List<Schedule> scheduleList = scheduleController.getAllAvailableSchedules();
        return scheduleList.stream().anyMatch(schedule -> schedule.getScheduleId() == scheduleId);
	}
}
import controller.*;
import model.Schedule;
import database.ScheduleDB;
import java.sql.Timestamp;
import java.util.*;
import java.time.*;

public class Main {
    public static void main(String[] args) {
        BookingController bookingController = new BookingController();
        LocalDate bookingDate = LocalDate.now();  // Eksempel dato
        int phone = 20232024;
        int scheduleId = 73;  // Eksempel tidsplans-ID
        List<Integer> serviceIds = Arrays.asList(3, 4, 5);  // Eksempel service-IDs

        try {
        	System.out.println("Telefonnummer, der bruges til at søge kunde: " + phone);
            bookingController.makeBooking(bookingDate, phone, scheduleId, serviceIds);
            System.out.println("Booking blev succesfuldt oprettet.");
        } catch (Exception e) {
            System.err.println("Fejl under oprettelse af booking: " + e.getMessage());
        }
    }
}
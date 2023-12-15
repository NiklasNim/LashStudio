package database;

import java.sql.PreparedStatement;
import java.util.List;

import connectDatabase.DatabaseConnection;
import model.Booking;

public class BookingDB implements BookingDBIF {
	

    public void addBooking(Booking booking) {
        String sqlQuery = "INSERT INTO Booking (bookingDate, customerId, /* andre felter */) VALUES (?, ?, /* andre værdier */)";

        try {
            DatabaseConnection dbConn = DatabaseConnection.getInstance();
            try (PreparedStatement pstmt = dbConn.getConnection().prepareStatement(sqlQuery)) {
                
                pstmt.setDate(1, java.sql.Date.valueOf(booking.getBookingDate()));
                pstmt.setInt(2, booking.getCustomerId());
            

                int affectedRows = pstmt.executeUpdate();
                if (affectedRows > 0) {
                    System.out.println("New booking added successfully.");
                } else {
                    System.out.println("Failed to add the booking.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error occurred while adding the booking: " + e.getMessage());
        }
    }

	@Override
	public List<Booking> getBookings() {
		// TODO Auto-generated method stub
		return null;
	}



}

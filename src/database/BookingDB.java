package database;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import connectDatabase.DatabaseConnection;
import model.Booking;
import model.BookingLine;

public class BookingDB implements BookingDBIF {
	
	public void addBooking(Booking booking) {
	    String sqlQuery = "INSERT INTO Booking values (?, ?)";

	    try {
	        DatabaseConnection dbConn = DatabaseConnection.getInstance();
	        try (PreparedStatement pstmt = dbConn.getConnection().prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS)) {
	            
	            pstmt.setDate(1, java.sql.Date.valueOf(booking.getBookingDate()));
	            pstmt.setInt(2, booking.getCustomerId());

	            int affectedRows = pstmt.executeUpdate();
	            if (affectedRows == 0) {
	                throw new SQLException("Oprettelse af booking fejlede, ingen rækker påvirket.");
	            }
	   	            
	            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
	                if (generatedKeys.next()) {
	                	int bookingId = generatedKeys.getInt(1);
	                	for (BookingLine bookingLine : booking.getBookingLines())
	        	        	addBookingLine(bookingLine, bookingId);
	               
	                } else {
	                    throw new SQLException("Oprettelse af booking fejlede, intet ID opnået.");
	                }
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.out.println("Error occurred while adding the booking: " + e.getMessage());
	    }

	}

	private void addBookingLine(BookingLine bookingLine, int bookingId) {
		String sqlQuery = "INSERT INTO BookingLine values (?, ?, ?, ?)";
	    
	    try {
	        DatabaseConnection dbConn = DatabaseConnection.getInstance();
	        try (PreparedStatement pstmt = dbConn.getConnection().prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS)) {
	            
	            pstmt.setBigDecimal(1, bookingLine.getUnitPrice());
	            pstmt.setInt(2, bookingLine.getServiceId());
	            pstmt.setInt(3, bookingId);
	            pstmt.setInt(4, bookingLine.getScheduleId());
	           
	            int affectedRows = pstmt.executeUpdate();
	            if (affectedRows == 0) {
	                throw new SQLException("Oprettelse af booking fejlede, ingen rækker påvirket.");
	            }

	            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
	                if (!generatedKeys.next()) {
	                    throw new SQLException("Oprettelse af booking fejlede, intet ID opnået.");
	                }
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.out.println("Error occurred while adding the booking: " + e.getMessage());
	    }
	}
}
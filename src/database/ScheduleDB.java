package database;
import model.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import connectDatabase.DatabaseConnection;

public class ScheduleDB implements ScheduleDBIF {
	
	// Henter alle de ledige tider, der er ikke er booket indenfor de næste 7 dage
	public List<Schedule> getAllAvailableSchedules() {
	    List<Schedule> schedules = new ArrayList<>();
	    String sql = "SELECT schedule.* FROM Schedule " +
	                 "LEFT JOIN BookingLine ON BookingLine.scheduleId_FK = Schedule.scheduleId " +
	                 "WHERE BookingLine.bookingLineId IS NULL " +
	                 "AND startTime <= DATEADD(day, 7, GetDate()) " +
	                 "AND startTime > GetDate()";

	    try {
	        DatabaseConnection dbConn = DatabaseConnection.getInstance();
	        PreparedStatement pstmt = dbConn.getConnection().prepareStatement(sql);
	        ResultSet rs = pstmt.executeQuery();

	        System.out.println(LocalDateTime.now()  + " - Indhenter alle tilgængelige tidsplaner");
	        while (rs.next()) {
	            int scheduleId = rs.getInt("scheduleId");
	            Timestamp startTime = rs.getTimestamp("startTime");
	            Timestamp endTime = rs.getTimestamp("endTime");
	            int employeeId_FK = rs.getInt("employeeId_FK");

	            Schedule schedule = new Schedule(scheduleId, startTime, endTime, employeeId_FK);
	            schedules.add(schedule);
	        }
	    } catch (SQLException sExc) {
	        sExc.printStackTrace();
	      
	    }

	    return schedules;
	}

	// Finder en tidsplan baseret på scheduleId
    public Schedule findScheduleById(int scheduleId) {
        String sqlQuery = "SELECT * FROM Schedule WHERE scheduleId = ?";
        Schedule schedule = null;

        try {
            DatabaseConnection dbConn = DatabaseConnection.getInstance();
            PreparedStatement pstmt = dbConn.getConnection().prepareStatement(sqlQuery);
            pstmt.setInt(1, scheduleId);

            System.out.println("Leder efter tidsplan med scheduleId: " + scheduleId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                Timestamp startTime = rs.getTimestamp("startTime");
                Timestamp endTime = rs.getTimestamp("endTime");
                int employeeId_FK = rs.getInt("employeeId_FK");

                schedule = new Schedule(scheduleId, startTime, endTime, employeeId_FK);
                System.out.println("Found schedule: " + schedule.toString());
            } else {
                System.out.println("Ingen tidsplan fundet med scheduleId: " + scheduleId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Fejl opstået under søgning efter tidsplane: " + e.getMessage());
        }

        return schedule;
    }
	
    // Markerer en tidsplan som booket
    public void markScheduleAsBooked(Schedule schedule) {
        String sqlQuery = "UPDATE Schedule SET isBooked = true WHERE scheduleId = ?";

        try {
            DatabaseConnection dbConn = DatabaseConnection.getInstance();
            try (PreparedStatement pstmt = dbConn.getConnection().prepareStatement(sqlQuery)) {
                pstmt.setInt(1, schedule.getScheduleId());

                int affectedRows = pstmt.executeUpdate();
                if (affectedRows > 0) {
                    System.out.println("Tidsplan med id " + schedule.getScheduleId() + " er markeret som booket.");
                } else {
                    System.out.println("Ingen tidsplan var markeret som booket. ScheduleId eksisterer måske ikke.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Fejl opstået under markeringen af tidsplan for booking: " + e.getMessage());
        }
    }
}

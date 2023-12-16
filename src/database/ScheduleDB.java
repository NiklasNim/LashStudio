package database;
import model.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import connectDatabase.DatabaseConnection;

public class ScheduleDB implements ScheduleDBIF {
	
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

	        System.out.println("Indhenter alle tilgængelige tidsplaner for de næste 7 dage");
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

	
    public Schedule findScheduleById(int scheduleId) {
        String sqlQuery = "SELECT * FROM Schedule WHERE scheduleId = ?";
        Schedule schedule = null;

        try {
            DatabaseConnection dbConn = DatabaseConnection.getInstance();
            PreparedStatement pstmt = dbConn.getConnection().prepareStatement(sqlQuery);
            pstmt.setInt(1, scheduleId);

            System.out.println("Searching for schedule with scheduleId: " + scheduleId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                Timestamp startTime = rs.getTimestamp("startTime");
                Timestamp endTime = rs.getTimestamp("endTime");
                int employeeId_FK = rs.getInt("employeeId_FK");

                schedule = new Schedule(scheduleId, startTime, endTime, employeeId_FK);
                System.out.println("Found schedule: " + schedule.toString());
            } else {
                System.out.println("No schedule found with scheduleId: " + scheduleId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error occurred while searching for schedule: " + e.getMessage());
        }

        return schedule;
    }
	
    public void markScheduleAsBooked(Schedule schedule) {
        String sqlQuery = "UPDATE Schedule SET isBooked = true WHERE scheduleId = ?";

        try {
            DatabaseConnection dbConn = DatabaseConnection.getInstance();
            try (PreparedStatement pstmt = dbConn.getConnection().prepareStatement(sqlQuery)) {
                pstmt.setInt(1, schedule.getScheduleId());

                int affectedRows = pstmt.executeUpdate();
                if (affectedRows > 0) {
                    System.out.println("Schedule with scheduleId " + schedule.getScheduleId() + " has been marked as booked.");
                } else {
                    System.out.println("No schedule was marked as booked. ScheduleId might not exist.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error occurred while marking schedule as booked: " + e.getMessage());
        }
    }
}

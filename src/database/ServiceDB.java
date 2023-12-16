package database;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.*;
import connectDatabase.DatabaseConnection;
import model.Schedule;
import model.Service;

public class ServiceDB implements ServiceDBIF {

	public static ServiceDB instance;

	public static ServiceDB getInstance() {
		if (instance == null) {
			instance = new ServiceDB();
		}
		return instance;
	}

    public Service findServiceById(int serviceId) {
        String sqlQuery = "SELECT * FROM service WHERE serviceId = ?";
        Service service = null;

        try {
            DatabaseConnection dbConn = DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = dbConn.getConnection().prepareStatement(sqlQuery);
            
            preparedStatement.setInt(1, serviceId);
            ResultSet rs = preparedStatement.executeQuery();
            
            if (rs.next()) {
                int serviceID = rs.getInt("serviceId");
                BigDecimal price = rs.getBigDecimal("price");
                String description = rs.getString("description");
                String serviceType = rs.getString("serviceType");
                int locationId = rs.getInt("locationId_FK");

                service = new Service(serviceID, price, description, serviceType, locationId);
            }
        } catch (SQLException sExc) {
            sExc.printStackTrace();
        }
        return service;
    }

	public LocalDateTime findAvailableServiceDates(int serviceId) {
		String sqlQuery = "SELECT timePeriod FROM service WHERE serviceId = ?";
		LocalDateTime availableTime = null;

		try {
			DatabaseConnection dbConn = DatabaseConnection.getInstance();
			PreparedStatement preparedStatement = dbConn.getConnection().prepareStatement(sqlQuery);

			preparedStatement.setInt(1, serviceId);
			ResultSet rs = preparedStatement.executeQuery();
			System.out.println("Finding available time for service with serviceId " + serviceId);

			while (rs.next()) {
				Timestamp timePeriod = rs.getTimestamp("timePeriod");
				availableTime = timePeriod.toLocalDateTime();
				System.out.println("Found available time: " + availableTime);
			}
		} catch (SQLException sExc) {
			sExc.printStackTrace();
		}
		return availableTime;
	}

	public List<Schedule> getAllAvailableDates() {
		List<Schedule> schedules = new ArrayList<>();
		String sqlQuery = "SELECT * FROM Schedule LEFT JOIN BookingLine ON BookingLine.scheduleId_FK = Schedule.ScheduleId WHERE BookingLine.bookingLineId IS NULL";

		try {
			DatabaseConnection dbConn = DatabaseConnection.getInstance();
			PreparedStatement pstmt = dbConn.getConnection().prepareStatement(sqlQuery);
			ResultSet rs = pstmt.executeQuery();

			System.out.println("Fetching all available schedules");
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
	
	public List<Service> getAllServices() {
        List<Service> services = new ArrayList<>();
        String sql = "SELECT * FROM service";
        try {
            DatabaseConnection dbConn = DatabaseConnection.getInstance();
            Statement statement = dbConn.getConnection().createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                int serviceId = rs.getInt("serviceId");
                BigDecimal price = rs.getBigDecimal("price");
                String description = rs.getString("description");
                String serviceType = rs.getString("serviceType");
                int locationId = rs.getInt("locationId_FK");

                services.add(new Service(serviceId, price, description, serviceType, locationId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return services;
    }
}

/*
 * public List<Service> findAllServices() { List<Service> services = new
 * ArrayList<>();
 * 
 * 
 * try (Connection connection = connect(); PreparedStatement statement =
 * connection.prepareStatement("SELECT * FROM services"); ResultSet resultSet =
 * statement.executeQuery()) {
 * 
 * while (resultSet.next()) { int serviceId = resultSet.getInt("serviceId");
 * Timestamp timePeriod = resultSet.getTimestamp("timePeriod"); BigDecimal price
 * = resultSet.getBigDecimal("price"); String description =
 * resultSet.getString("description"); String serviceType =
 * resultSet.getString("serviceType");
 * 
 * Service service = new Service(serviceId, timePeriod, price, description,
 * serviceType); services.add(service); } } catch (SQLException e) {
 * e.printStackTrace(); }
 * 
 * return services; }
 */

/*
 * public void createService(Service newService) { try (Connection connection =
 * connect()) { String sql =
 * "INSERT INTO services (timePeriod, price, description, serviceType) VALUES (?, ?, ?, ?)"
 * ;
 * 
 * try (PreparedStatement statement = connection.prepareStatement(sql)) {
 * statement.setTimestamp(1, new
 * Timestamp(newService.getTimePeriod().getTime())); statement.setBigDecimal(2,
 * newService.getPrice()); statement.setString(3, newService.getDescription());
 * statement.setString(4, newService.getServiceType());
 * 
 * int rowsInserted = statement.executeUpdate();
 * 
 * if (rowsInserted > 0) { System.out.println("Service created successfully!");
 * } else { System.out.println("Failed to create service."); } } } catch
 * (SQLException e) { e.printStackTrace(); } }
 */

package database;
import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;
import connectDatabase.DatabaseConnection;
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

}
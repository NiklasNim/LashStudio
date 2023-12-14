package database;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;


import connectDatabase.DatabaseConnection;
import model.Service;


public class ServiceDB implements ServiceDBIF {
	
	
	public static ServiceDB instance;
	
		public static ServiceDB getInstance() {
			if (instance == null)
			{
				instance = new ServiceDB();
			}
			return instance;
		}
		
	
	public Service findServiceById(int serviceId) {
		String sqlQuery = "SELECT * from service where serviceId = " + serviceId;
		 try {
	        	DatabaseConnection dbConn = DatabaseConnection.getInstance();
	        	Statement sqlStat = dbConn.getConnection().createStatement();
	               ResultSet rs = sqlStat.executeQuery(sqlQuery);
	               System.out.println("Finding service with serviceId " + serviceId);
	            while(rs.next()) {
	                   String location = rs.getString("location");
	                   int serviceID = rs.getInt("serviceId");
	                   Timestamp timePeriod = rs.getTimestamp("timePeriod");
	                   BigDecimal price = rs.getBigDecimal("price");
	                   String description = rs.getString("description");
	                   String serviceType = rs.getString("serviceType");
	                   System.out.println("Found service " + location + "\t" + serviceID + "\t" + timePeriod + "\t" + price + "\t" + description + "\t" + serviceType);      
	                   
	                   return new Service(serviceId, timePeriod, price, description, serviceType);
	                }
	             }     
	             catch(SQLException sExc) {
	                    sExc.printStackTrace();    
	            }
	             return null;
	     	
	     	}


	/*public List<Service> findAllServices() {
		List<Service> services = new ArrayList<>();
		

		try (Connection connection = connect();
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM services");
				ResultSet resultSet = statement.executeQuery()) {

			while (resultSet.next()) {
				int serviceId = resultSet.getInt("serviceId");
				Timestamp timePeriod = resultSet.getTimestamp("timePeriod");
				BigDecimal price = resultSet.getBigDecimal("price");
				String description = resultSet.getString("description");
				String serviceType = resultSet.getString("serviceType");

				Service service = new Service(serviceId, timePeriod, price, description, serviceType);
				services.add(service);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return services;
	}*/
	
	
	

	/*public void createService(Service newService) {
		try (Connection connection = connect()) {
			String sql = "INSERT INTO services (timePeriod, price, description, serviceType) VALUES (?, ?, ?, ?)";

			try (PreparedStatement statement = connection.prepareStatement(sql)) {
				statement.setTimestamp(1, new Timestamp(newService.getTimePeriod().getTime()));
				statement.setBigDecimal(2, newService.getPrice());
				statement.setString(3, newService.getDescription());
				statement.setString(4, newService.getServiceType());

				int rowsInserted = statement.executeUpdate();

				if (rowsInserted > 0) {
					System.out.println("Service created successfully!");
				} else {
					System.out.println("Failed to create service.");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}*/
	
	
	public LocalDate findAvailableServiceDates(int serviceId) {
	    String sqlQuery = "SELECT timePeriod FROM services WHERE serviceId = ?";
	    LocalDate availableTime = null;

	    try {DatabaseConnection dbConn = DatabaseConnection.getInstance();
	         PreparedStatement preparedStatement = dbConn.getConnection().prepareStatement(sqlQuery);
	    	
	        preparedStatement.setInt(1, serviceId);
	        ResultSet rs = preparedStatement.executeQuery();
	        System.out.println("Finding available time for service with serviceId " + serviceId);

	        while (rs.next()) {
	            Timestamp timePeriod = rs.getTimestamp("timePeriod");
	            availableTime = timePeriod.toLocalDateTime().toLocalDate();
	            System.out.println("Found available time: " + availableTime);
	        }
	    } catch (SQLException sExc) {
	        sExc.printStackTrace();
	    }
	    return availableTime;
	}

}



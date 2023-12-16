package database;

import model.Customer;
import java.util.*;
import java.sql.*;
import connectDatabase.DatabaseConnection;


public class CustomerDB implements CustomerDBIF {

	public static CustomerDB instance;
    public static CustomerDB getInstance() {
        if (instance == null) {
            instance = new CustomerDB();
        }
        return instance;
    }


    public void createCustomer(Customer newCustomer) {
        String sql = "INSERT INTO customer (firstName, lastName, phone) VALUES (?, ?, ?)";

        try {
            DatabaseConnection dbConn = DatabaseConnection.getInstance();
            try (PreparedStatement statement = dbConn.getConnection().prepareStatement(sql)) {
                statement.setString(1, newCustomer.getFirstName());
                statement.setString(2, newCustomer.getLastName());
                statement.setInt(3, newCustomer.getPhone());

                int rowsInserted = statement.executeUpdate();

                if (rowsInserted > 0) {
                    System.out.println("Customer created successfully!");
                } else {
                    System.out.println("Failed to create customer.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Customer findCustomerByPhone(int phone) {
        Customer foundCustomer = null;
        String sql = "SELECT * FROM customer WHERE phone = ?";

        System.out.println("Søger efter kunde med telefonnummer: " + phone); // Log telefonnummeret

        try {
            DatabaseConnection dbConn = DatabaseConnection.getInstance();
            try (PreparedStatement statement = dbConn.getConnection().prepareStatement(sql)) {
                statement.setInt(1, phone); // Telefonnummeret håndteres som en int

                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        int customerId = resultSet.getInt("customerId");
                    	String firstName = resultSet.getString("firstName");
                        String lastName = resultSet.getString("lastName");
                        int retrievedPhone = resultSet.getInt("phone");

                        foundCustomer = new Customer(customerId, firstName, lastName, retrievedPhone);
                        System.out.println("Kunde fundet: " + foundCustomer); // Log det fundne Customer objekt
                    } else {
                        System.out.println("Ingen kunde fundet med telefonnummeret: " + phone); // Log hvis ingen kunde blev fundet
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Database fejl under søgning efter kunde: " + e.getMessage()); // Log en fejlmeddelelse
            e.printStackTrace();
        }

        return foundCustomer;
    }

	@Override
	public List<Customer> findAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

}


//Er dette relevant for vores use case? Hvis det ikke bruges skal det ikke med	
//	public List<Customer> findAllCustomers() {
//		List<Customer> customers = new ArrayList<>();
//
//		try (Connection connection = connect();
//				PreparedStatement statement = connection.prepareStatement("SELECT * FROM customers");
//				ResultSet resultSet = statement.executeQuery()) {
//
//			while (resultSet.next()) {
//				String firstName = resultSet.getString("firstName");
//				String lastName = resultSet.getString("lastName");
//				int phone = resultSet.getInt("phone");
//
//				Customer customer = new Customer(firstName, lastName, phone);
//				customers.add(customer);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		return customers;
//	}


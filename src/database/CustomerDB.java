package database;

import model.Customer;
import java.util.*;
import java.sql.*;

public class CustomerDB implements CustomerDBIF {
	private static final String URL = "jdbc:mysql://localhost:3306/your_database";
	private static final String USER = "your_username";
	private static final String PASSWORD = "your_password";

	public static Connection connect() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}

	public List<Customer> findAllCustomers() {
		List<Customer> customers = new ArrayList<>();

		try (Connection connection = connect();
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM customers");
				ResultSet resultSet = statement.executeQuery()) {

			while (resultSet.next()) {
				String firstName = resultSet.getString("firstName");
				String lastName = resultSet.getString("lastName");
				int phone = resultSet.getInt("phone");
				// Add other customer attributes as needed

				Customer customer = new Customer(firstName, lastName, phone);
				customers.add(customer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return customers;
	}

	public void createCustomer(Customer newCustomer) {
		try (Connection connection = connect()) {
			String sql = "INSERT INTO customers (firstName, lastName, phone) VALUES (?, ?, ?)";

			try (PreparedStatement statement = connection.prepareStatement(sql)) {
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

		try (Connection connection = connect()) {
			String sql = "SELECT * FROM customers WHERE phone = ?";

			try (PreparedStatement statement = connection.prepareStatement(sql)) {
				statement.setInt(1, phone);

				try (ResultSet resultSet = statement.executeQuery()) {
					if (resultSet.next()) {
						String firstName = resultSet.getString("firstName");
						String lastName = resultSet.getString("lastName");
						int retrievedPhone = resultSet.getInt("phone");

						foundCustomer = new Customer(firstName, lastName, retrievedPhone);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return foundCustomer;
	}

}

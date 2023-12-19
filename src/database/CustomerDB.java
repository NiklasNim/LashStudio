package database;
import model.Customer;
import java.sql.*;
import connectDatabase.DatabaseConnection;

public class CustomerDB implements CustomerDBIF {

	// Opretter en ny kunde i databasen
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
                    System.out.println("Kunde oprette!Customer created successfully!");
                } else {
                    System.out.println("Fejlede på at oprette kunde.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Metode til at finde en kunde på telefonnummer 
    public Customer findCustomerByPhone(int phone) {
        Customer foundCustomer = null;
        String sql = "SELECT * FROM customer WHERE phone = ?";

        System.out.println("Søger efter kunde med telefonnummer: " + phone);

        try {
            DatabaseConnection dbConn = DatabaseConnection.getInstance();
            try (PreparedStatement statement = dbConn.getConnection().prepareStatement(sql)) {
                statement.setInt(1, phone);

                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        int customerId = resultSet.getInt("customerId");
                    	String firstName = resultSet.getString("firstName");
                        String lastName = resultSet.getString("lastName");
                        int retrievedPhone = resultSet.getInt("phone");

                        foundCustomer = new Customer(customerId, firstName, lastName, retrievedPhone);
                        System.out.println("Kunde fundet: " + foundCustomer);
                    } else {
                        System.out.println("Ingen kunde fundet med telefonnummeret: " + phone);
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Database fejl under søgning efter kunde: " + e.getMessage()); 
            e.printStackTrace();
        }

        return foundCustomer;
    }
}
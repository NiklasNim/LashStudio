package database;
import model.Customer;

public interface CustomerDBIF {
	// Metode til at oprette en ny kunde i databasen
	void createCustomer(Customer newCustomer);
	
	// Metode til at finde en kunde på telefonnummer i databasen
	Customer findCustomerByPhone(int phone);
}
package controller;
import database.CustomerDB;
import database.CustomerDBIF;
import model.*;

public class CustomerController {
	private CustomerDBIF customerDB;
	
	// Konstruktør til at initialisere CustomerDBIF implementeringen 
	public CustomerController() {
		this.customerDB = new CustomerDB();
	}
	
	// Opretter en ny kunde med de angivne oplysninger og gemmer i databasen
	public void createCustomer(int customerId, String firstName, String lastName, int phone) {
        Customer newCustomer = new Customer(customerId, firstName, lastName, phone);
        customerDB.createCustomer(newCustomer);
    }
	
	// Finder en kunde baseret på telefonnummer
    public Customer findCustomerByPhone(int phone) {
        return customerDB.findCustomerByPhone(phone);
    }
}
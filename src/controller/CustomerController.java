package controller;
import database.CustomerDB;
import database.CustomerDBIF;
import model.*;

public class CustomerController {
	private CustomerDBIF customerDB;

	public CustomerController() {
		this.customerDB = new CustomerDB();
	}

	public void createCustomer(int customerId, String firstName, String lastName, int phone) {
        Customer newCustomer = new Customer(customerId, firstName, lastName, phone);
        customerDB.createCustomer(newCustomer);
    }

    public Customer findCustomerByPhone(int phone) {
        return customerDB.findCustomerByPhone(phone);
    }
}
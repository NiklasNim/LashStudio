package controller;
import java.util.*;

import database.CustomerDB;
import model.*;

public class CustomerController {
	private CustomerDB customerDB;

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
    
	public List<Customer> findAllCustomers() {
		return customerDB.findAllCustomers();
	}
}
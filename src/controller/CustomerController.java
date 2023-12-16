package controller;

import java.util.*;

import database.CustomerDB;
import model.*;

public class CustomerController {
	private List<Customer> customers;
	private CustomerDB customerDB;

	public CustomerController() {
		this.customers = new ArrayList<>();
		this.customerDB = new CustomerDB();
        this.customers = customerDB.findAllCustomers();
	}

	public void createCustomer(int customerId, String firstName, String lastName, int phone) {
        Customer newCustomer = new Customer(customerId, firstName, lastName, phone);
        customers.add(newCustomer);

        customerDB.createCustomer(newCustomer);
    }

//    public List<Customer> findAllCustomersByPhone(int phone) {
//        return customerDB.findAllCustomersByPhone(phone);
//    }

    public Customer findCustomerByPhone(int phone) {
        return customerDB.findCustomerByPhone(phone);
    }
}
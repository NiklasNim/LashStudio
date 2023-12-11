package controller;

import java.util.*;
import model.*;

public class CustomerController {
	private List<Customer> customers;

	public CustomerController() {
		this.customers = new ArrayList<>();
	}
	
	public void createCustomer(String firstName, String lastName, int phone) {
		Customer customer = new Customer(firstName, lastName, phone);
		customers.add(customer);
	}
	
	public List<Customer> findAllCustomers() {
		return customers;
	}

	public Customer findCustomerByPhone(int phone) {
		for (Customer customer : customers) {
			if (customer.getPhone() == phone) {
				return customer;
			}
		}
		return null;
	}
}

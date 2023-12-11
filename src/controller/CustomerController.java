package controller;

import java.util.*;

import model.*;

public class CustomerController {
	private List<Customer> customers;

	public CustomerController() {
		this.customers = new ArrayList<>();
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

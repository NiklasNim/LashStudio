package controller;
import java.util.*;

import model.*; 

public class CustomerController {
	private List<Customer> customerList; 
	
	public CustomerController() {
		this.customerList = new ArrayList<>(); 
	}
	public Customer findCustomerByPhone(int phone) {
		for (Customer customer : customerList) {
			if (customer.getPhone() == phone) {
				return customer;
			}
		}
		return null;
	}
}

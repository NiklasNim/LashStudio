package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import model.Customer;
import database.CustomerDB;

public class TestCustomer {

	private CustomerDB customerDB;
	private Customer existingCustomer;

	@BeforeEach
	void setUp() {
		customerDB = new CustomerDB();
		existingCustomer = customerDB.findCustomerByPhone(20232024);

	}

	@AfterEach
	void tearDown() {
		customerDB = null;
		existingCustomer = null;
	}

	// Testing the customer's first name.
	@Test
	void testCustomerFirstName() {
		assertEquals("Henrik", existingCustomer.getFirstName(), "The customer's first name should match.");
	}

	// Testing the customer's last name.
	@Test
	void testCustomerLastName() {
		assertEquals("Larsen", existingCustomer.getLastName(), "The customer's last name should match.");
	}

	// Testing the customer's phone.
	@Test
	void testCustomerPhone() {
		assertEquals(20232024, existingCustomer.getPhone(), "	The customer phone should match.");
	}
}

package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import model.Customer;

public class TestCustomer {

	private Customer customer;

	@BeforeEach
	void setUp() {
	}

	@AfterEach
	void tearDown() {
		customer = null;
	}

	//Testing the customer's first name.
	@Test 
	void testCustomerFirstName() {
		assertEquals("Bo", customer.getFirstName(), "The customer's first name should match.");
	}

	//Testing the customer's last name.
	@Test
	void testCustomerLastName() {
		assertEquals("Benzon", customer.getLastName(), "The customer's last name should match.");
	}

	//Testing the customer's phone.
	@Test
	void testCustomerPhone() {
		assertEquals("19981999", customer.getPhone(), "The customer phone should match.");
	}

}

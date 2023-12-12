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

	@Test
	void testFirstName() {
		assertEquals("Bo", customer.getFirstName(), "The customer's first name should match.");
	}

	@Test
	void testLastName() {
		assertEquals("Benzon", customer.getLastName(), "The customer's last name should match.");
	}

	@Test
	void testCustomerPhone() {
		assertEquals("19981999", customer.getPhone(), "The customer phone should match.");
	}

}

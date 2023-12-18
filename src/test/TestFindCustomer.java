package test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import controller.CustomerController;
import model.Customer;

public class TestFindCustomer {

	@Test
	// Her testes metoden "findCustomerByPhone()" med AAA-Test.
	void testFindCustomerByPhone() {

		// Arrange
		CustomerController customerController = new CustomerController();
		int phone = 20232024;

		// Act
		Customer foundCustomer = customerController.findCustomerByPhone(phone);

		// Assert
		assertNotNull(foundCustomer, "Kunden burde ikke være null");
		System.out.println("Testen returnerede kunden: " + foundCustomer.getFirstName() + " "
				+ foundCustomer.getLastName() + ", hvilket bekræfter testen.");
	}
}





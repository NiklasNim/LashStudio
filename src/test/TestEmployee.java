package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import model.Employee;

public class TestEmployee {

	private Employee employee;

	@BeforeEach
	void setUp() {

	}

	@AfterEach
	void tearDown() {
		employee = null;
	}

	//Testing the employee's first name.
	@Test
	void testEmployeeFirstName() {
		assertEquals("Rikke", employee.getFirstName(), "The employee's first name should match.");
	}

	//Testing the employee's last name.
	@Test
	void testEmployeeLastName() {
		assertEquals("Fage", employee.getLastName(), "The employee's last name should match.");
	}

	//Testing the employee's id.
	@Test
	void testEmployeeId() {
		assertEquals(2, employee.getEmployeeId(), "The employee id should match.");
	}

}
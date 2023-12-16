package model;

public class Customer {
	private int customerId;
	private String firstName;
	private String lastName;
	private int phone;

	public Customer(int customerId, String firstName, String lastName, int phone) {
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
	}

	public String getLastName() {
		return lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getCustomer() {
		return firstName + " " + lastName + " " + phone;
	}
	
	public int getCustomerId() {
		return customerId;
	}
}

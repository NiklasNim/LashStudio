package database;
import model.Customer;

public interface CustomerDBIF {
	void createCustomer(Customer newCustomer);
	Customer findCustomerByPhone(int phone);
}
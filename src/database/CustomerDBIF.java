package database;

import java.util.List;
import model.Customer;

public interface CustomerDBIF {

	List<Customer> findAllCustomers();

	void createCustomer(Customer newCustomer);

	Customer findCustomerByPhone(int phone);

}

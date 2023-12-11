package database;

import model.Product;
import java.util.*;

public interface ProductDBIF {

	List<Product> findAllProducts();
	
	void createProductByBarcode(Product product);
}

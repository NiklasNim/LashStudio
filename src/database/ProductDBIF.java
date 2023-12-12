package database;

import model.Product;

import java.math.BigDecimal;
import java.util.*;

public interface ProductDBIF {

	List<Product> findAllProducts();
	
	void createProductByBarcode(String name, Date expirationDate, String type, int stock, int minStock, BigDecimal price, int barcode);
}

package database;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import model.Product;

public interface ProductDBIF {

    List<Product> findAllProducts();

    void createProduct(String name, Date expirationDate, String type, int stock, int minStock, BigDecimal price, int barcode);
}

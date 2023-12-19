package controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import database.ProductDB;
import model.Product;

public class ProductController {
    private ProductDB productDB;

    public ProductController() {
        this.productDB = new ProductDB();
    }

    public List<Product> findAllProducts() {
        return productDB.findAllProducts();
    }

    public void createProduct(String name, Date expirationDate, String type, int stock, int minStock, BigDecimal price, int barcode) {
        productDB.createProduct(name, expirationDate, type, stock, minStock, price, barcode);
    }
}

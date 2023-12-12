package controller;

import model.*;

import java.math.*;
import java.util.*;

import database.ProductDB;

public class ProductController {
	private List<Product> products;
	private ProductDB productDB;

	public ProductController() {
		this.products = new ArrayList<>();
		this.products = new ProductDB().findAllProducts();
        this.productDB = new ProductDB();
	}

	public void createProduct(String name, Date expirationDate, String type, int stock, int minStock, BigDecimal price,
			int barcode) {
		Product newProduct = new Product(name, expirationDate, type, stock, minStock, price, barcode);
		products.add(newProduct);


		productDB.createProduct(name, expirationDate, type, stock, minStock, price, barcode);
	}

	public List<Product> findAllProducts() {
		return products;
	}
}
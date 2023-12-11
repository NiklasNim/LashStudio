package controller;

import model.*;

import java.math.*;
import java.util.*;

public class ProductController {
	private List<Product> products; // God java-etik

	public ProductController() {
		this.products = new ArrayList<>();
	}

	public void addProduct(String name, Date expirationDate, String type, int stock, int minStock, BigDecimal price,
			int barcode) {
		Product product = new Product(name, expirationDate, type, stock, minStock, price, barcode);
		products.add(product);
	}

	public List<Product> getAllProducts() {
		return products;
	}

	public Product getProductByBarcode(int barcode) {
		for (Product product : products) {
			if (product.getBarcode() == barcode) {
				return product;
			}
		}
		return null;
	}

	public void updateProduct(int barcode, int newStock, BigDecimal newPrice) {
		Product product = getProductByBarcode(barcode);
		if (product != null) {
			product.setStock(newStock);
			product.setPrice(newPrice);
		} else {
			System.out.println("Product not found.");
		}
	}

	public void removeProduct(int barcode) {
		Product product = getProductByBarcode(barcode);
		if (product != null) {
			products.remove(product);
		} else {
			System.out.println("Product not found.");
		}
	}

}

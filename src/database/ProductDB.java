package database;

import java.sql.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Product;

public class ProductDB implements ProductDBIF {

	private static final String URL = "jdbc:mysql://localhost:3306/your_database";
	private static final String USER = "your_username";
	private static final String PASSWORD = "your_password";

	public static Connection connect() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}

	public List<Product> findAllProducts() {
		List<Product> products = new ArrayList<>();

		try (Connection connection = connect();
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM products");
				ResultSet resultSet = statement.executeQuery()) {

			while (resultSet.next()) {
				String name = resultSet.getString("name");
				Date expirationDate = resultSet.getDate("expirationDate");
				String type = resultSet.getString("type");
				int stock = resultSet.getInt("stock");
				int minStock = resultSet.getInt("minStock");
				BigDecimal price = resultSet.getBigDecimal("price");
				int barcode = resultSet.getInt("barcode");

				Product product = new Product(name, expirationDate, type, stock, minStock, price, barcode);
				products.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return products;
	}

	public void createProduct(String name, Date expirationDate, String type, int stock, int minStock, BigDecimal price, int barcode) {
		try (Connection connection = connect()) {
			String sql = "INSERT INTO products (name, expirationDate, type, stock, minStock, price, barcode) VALUES (?, ?, ?, ?, ?, ?, ?)";

			try (PreparedStatement statement = connection.prepareStatement(sql)) {
				statement.setString(1, name);
				statement.setDate(2, new java.sql.Date(expirationDate.getTime()));
				statement.setString(3, type);
				statement.setInt(4, stock);
				statement.setInt(5, minStock);
				statement.setBigDecimal(6, price);
				statement.setInt(7, barcode);

				int rowsInserted = statement.executeUpdate();

				if (rowsInserted > 0) {
					System.out.println("Product created successfully!");
				} else {
					System.out.println("Failed to create product.");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
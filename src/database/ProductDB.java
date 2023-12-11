package database;

import java.sql.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Product;


public abstract class ProductDB implements ProductDBIF {

    private static final String URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";
    private ArrayList<Product> products;

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

   
    public void createProductByBarcode(Product product) {
		products.add(product);
	}
}
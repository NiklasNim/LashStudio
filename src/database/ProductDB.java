package database;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import connectDatabase.DatabaseConnection;
import model.Product;

public class ProductDB implements ProductDBIF {

    public List<Product> findAllProducts() {
        List<Product> products = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM Product")) {

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
            System.out.println("Error occurred while fetching products: " + e.getMessage());
        }

        return products;
    }

    public void createProduct(String name, Date expirationDate, String type, int stock, int minStock, BigDecimal price, int barcode) {
        try (Connection connection = DatabaseConnection.getInstance().getConnection()) {
            String sql = "INSERT INTO products (name, expirationDate, type, stock, minStock, price, barcode) VALUES (?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                pstmt.setString(1, name);
                pstmt.setDate(2, new java.sql.Date(expirationDate.getTime()));
                pstmt.setString(3, type);
                pstmt.setInt(4, stock);
                pstmt.setInt(5, minStock);
                pstmt.setBigDecimal(6, price);
                pstmt.setInt(7, barcode);

                int rowsInserted = pstmt.executeUpdate();

                if (rowsInserted > 0) {
                    System.out.println("Product created successfully!");
                } else {
                    System.out.println("Failed to create product.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error occurred while creating product: " + e.getMessage());
        }
    }
}

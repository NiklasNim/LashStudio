package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import connectDatabase.DatabaseConnection;
import model.Customer;
import model.Order;
import model.OrderLine;
import model.Product;
import database.OrderDB;
import database.ProductDB;

public class OrderController {
    private OrderDB orderDB;
    private ProductDB productDB;

    public OrderController() {
        this.orderDB = new OrderDB();
        this.productDB = new ProductDB();
    }

    public void createOrder(java.time.LocalDate orderDate, List<OrderLine> orderLines) {
        orderDB.addOrder(new Order(orderDate, 0));

        int orderId = getOrderFromDatabase(); 

        for (OrderLine orderLine : orderLines) {
            orderDB.addOrderLine(orderLine, orderId);
        }
    }

    public List<Product> findAllProducts() {
        return productDB.findAllProducts();
    }

    private int getOrderFromDatabase() {
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT MAX(orderId) AS maxOrderId FROM [dbo].[Order]");
             ResultSet resultSet = statement.executeQuery()) {

            if (resultSet.next()) {
                int maxOrderId = resultSet.getInt("maxOrderId");
                return maxOrderId;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error occurred while fetching order from the database: " + e.getMessage());
        }

        System.out.println("No order found in the database.");
        return -1;
    }
}
	
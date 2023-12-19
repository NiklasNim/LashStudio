package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import connectDatabase.DatabaseConnection;
import model.Order;
import model.OrderLine;

public class OrderDB implements OrderDBIF {

    public void addOrder(Order order) {
        String sqlQuery = "INSERT INTO OrderTable (order_date) VALUES (?)";

        try {
            DatabaseConnection dbConn = DatabaseConnection.getInstance();
            try (PreparedStatement pstmt = dbConn.getConnection().prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS)) {

                pstmt.setDate(1, java.sql.Date.valueOf(order.getOrderDate()));

                int affectedRows = pstmt.executeUpdate();
                if (affectedRows == 0) {
                    throw new SQLException("Creation of order failed, no rows affected.");
                }

                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int orderId = generatedKeys.getInt(1);
                        for (OrderLine orderLine : order.getOrderLines())
	        	        	addOrderLine(orderLine, orderId);
                    } else {
                        throw new SQLException("Creation of order failed, no ID obtained.");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error occurred while adding the order: " + e.getMessage());
        }
    }

    public void addOrderLine(OrderLine orderLine, int orderId) {
        String sqlQuery = "INSERT INTO OrderLine (unit_price, quantity, product_id, order_id) VALUES (?, ?, ?, ?)";

        try {
            DatabaseConnection dbConn = DatabaseConnection.getInstance();
            try (PreparedStatement pstmt = dbConn.getConnection().prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS)) {

                pstmt.setBigDecimal(1, orderLine.getUnitPrice());
                pstmt.setInt(2, orderLine.getQuantity());
                pstmt.setInt(3, orderLine.getProduct().getBarcode());
                pstmt.setInt(4, orderId);

                int affectedRows = pstmt.executeUpdate();
                if (affectedRows == 0) {
                    throw new SQLException("Creation of order line failed, no rows affected.");
                }

                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (!generatedKeys.next()) {
                        throw new SQLException("Creation of order line failed, no ID obtained.");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error occurred while adding the order line: " + e.getMessage());
        }
    }
}
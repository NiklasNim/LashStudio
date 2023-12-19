package database;

import model.Order;
import model.OrderLine;

public interface OrderDBIF {
    void addOrder(Order order);

    void addOrderLine(OrderLine orderLine, int orderId);
}
package service;

import DAO.domain.Order;
import DAO.domain.Product;

import java.util.List;

public interface OrderService {
    List<Order> getListOfOrdersByPhoneNumber(String phoneNumber);

    boolean addOrder(List<Product> dishes, String phoneNumber, String consumerName, String orderTime);

    List<Order> getListOfOrders();

    void deleteOrderByID(int id);

    void markOrderAsReady(int id);
}

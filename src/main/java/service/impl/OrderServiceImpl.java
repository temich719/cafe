package service.impl;

import DAO.domain.Order;
import DAO.domain.Product;
import service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    @Override
    public List<Order> getListOfOrdersByPhoneNumber(String phoneNumber) {
        return null;
    }

    @Override
    public boolean addOrder(List<Product> dishes, String phoneNumber, String consumerName, String orderTime) {
        return false;
    }

    @Override
    public List<Order> getListOfOrders() {
        return null;
    }

    @Override
    public void deleteOrderByID(int id) {

    }

    @Override
    public void markOrderAsReady(int id) {

    }
}

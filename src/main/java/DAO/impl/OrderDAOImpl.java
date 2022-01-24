package DAO.impl;

import DAO.AbstractDAO;
import DAO.ConnectionPool;
import DAO.OrderDAO;
import DAO.domain.Order;
import DAO.domain.Product;

import java.util.List;

public class OrderDAOImpl extends AbstractDAO implements OrderDAO {

    public OrderDAOImpl(ConnectionPool connectionPool) {
        super(connectionPool);
    }

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

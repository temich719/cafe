package DAO;

import DAO.domain.Order;
import DAO.exception.DAOException;

import java.util.List;

public interface OrderDAO {
    List<Order> getListOfOrdersByPhoneNumber(String phoneNumber) throws DAOException;

    void addOrder(String dishes, String fullPrice, String phoneNumber, String consumerName, String orderTime) throws DAOException;

    List<Order> getListOfOrders() throws DAOException;

    void deleteOrderByID(int id) throws DAOException;

    void markOrderAsReady(int id) throws DAOException;
}

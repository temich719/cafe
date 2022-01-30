package service;

import DAO.domain.Order;
import service.exception.ServiceException;

import java.util.List;

public interface OrderService {
    List<Order> getListOfOrdersByPhoneNumber(String phoneNumber) throws ServiceException;

    void addOrder(String dishes, String fullPrice, String phoneNumber, String consumerName, String orderTime) throws ServiceException;

    List<Order> getListOfOrders() throws ServiceException;

    void deleteOrderByID(int id) throws ServiceException;

    void markOrderAsReady(int id) throws ServiceException;
}

package service.impl;

import DAO.OrderDAO;
import DAO.daoFactory.DAOFactory;
import DAO.domain.Order;
import DAO.exception.DAOException;
import org.apache.log4j.Logger;
import service.OrderService;
import service.exception.ServiceException;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    private static final Logger LOGGER = Logger.getLogger(OrderServiceImpl.class);

    private final DAOFactory daoFactory = DAOFactory.getINSTANCE();
    private final OrderDAO orderDAO = daoFactory.getOrderDAO();

    @Override
    public List<Order> getListOfOrdersByPhoneNumber(String phoneNumber) throws ServiceException {
        try {
            return orderDAO.getListOfOrdersByPhoneNumber(phoneNumber);
        } catch (DAOException e) {
            LOGGER.error("Service Layer: " + e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public void addOrder(String dishes, String fullPrice, String phoneNumber, String consumerName, String orderTime) throws ServiceException {
        try {
            orderDAO.addOrder(dishes, fullPrice, phoneNumber, consumerName, orderTime);
        } catch (DAOException e) {
            LOGGER.error("Service Layer: " + e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Order> getListOfOrders() throws ServiceException {
        try {
            return orderDAO.getListOfOrders();
        } catch (DAOException e) {
            LOGGER.error("Service Layer: " + e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public void deleteOrderByID(int id) throws ServiceException {
        try {
            orderDAO.deleteOrderByID(id);
        } catch (DAOException e) {
            LOGGER.error("Service Layer: " + e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public void markOrderAsReady(int id) throws ServiceException {
        try {
            orderDAO.markOrderAsReady(id);
        } catch (DAOException e) {
            LOGGER.error("Service Layer: " + e.getMessage());
            throw new ServiceException(e);
        }
    }
}

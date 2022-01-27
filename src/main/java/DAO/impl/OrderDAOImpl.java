package DAO.impl;

import DAO.AbstractDAO;
import DAO.ConnectionPool;
import DAO.OrderDAO;
import DAO.domain.Order;
import DAO.exception.DAOException;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOImpl extends AbstractDAO implements OrderDAO {

    private static final String SELECT_ORDERS_BY_PHONE_NUMBER = "SELECT dishes, price, status FROM orders WHERE phoneNumber = ?;";
    private static final String ADD_ORDER = "INSERT INTO ORDERS(dishes, price, phoneNumber, consumerName, time, status) values(?, ?, ?, ?, ?, 'in process');";
    private static final String SELECT_ALL_ORDERS = "SELECT * FROM orders;";
    private static final String DELETE_ORDER_BY_ID = "DELETE FROM orders WHERE id = ?;";
    private static final String MARK_AS_READY = "UPDATE orders SET status = 'ready' WHERE id = ?;";

    private static final Logger LOGGER = Logger.getLogger(OrderDAOImpl.class);

    public OrderDAOImpl(ConnectionPool connectionPool) {
        super(connectionPool);
    }

    @Override
    public List<Order> getListOfOrdersByPhoneNumber(String phoneNumber) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = connectionPool.provide();
            preparedStatement = connection.prepareStatement(SELECT_ORDERS_BY_PHONE_NUMBER);
            preparedStatement.setString(1, phoneNumber);
            resultSet = preparedStatement.executeQuery();
            List<Order> orders = new ArrayList<>();
            while (resultSet.next()) {
                final Order order = new Order(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3));
                orders.add(order);
            }
            return orders;
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
            throw new DAOException("Can't get list of orders by phone number", e);
        } finally {
            connectionPool.retrieve(connection);
            close(resultSet, preparedStatement);
        }
    }

    @Override
    public void addOrder(String dishes, String fullPrice, String phoneNumber, String consumerName, String orderTime) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = connectionPool.provide();
            preparedStatement = connection.prepareStatement(ADD_ORDER);
            preparedStatement.setString(1, dishes);
            preparedStatement.setString(2, fullPrice);
            preparedStatement.setString(3, phoneNumber);
            preparedStatement.setString(4, consumerName);
            preparedStatement.setString(5, orderTime);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
            throw new DAOException("Can't add order", e);
        } finally {
            connectionPool.retrieve(connection);
            close(preparedStatement);
        }
    }

    @Override
    public List<Order> getListOfOrders() throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = connectionPool.provide();
            preparedStatement = connection.prepareStatement(SELECT_ALL_ORDERS);
            resultSet = preparedStatement.executeQuery();
            List<Order> orders = new ArrayList<>();
            while (resultSet.next()) {
                final Order order = new Order(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7));
                orders.add(order);
            }
            return orders;
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
            throw new DAOException("Can't get list of orders", e);
        } finally {
            connectionPool.retrieve(connection);
            close(resultSet, preparedStatement);
        }
    }

    @Override
    public void deleteOrderByID(int id) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = connectionPool.provide();
            preparedStatement = connection.prepareStatement(DELETE_ORDER_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
            throw new DAOException("Can't delete order", e);
        } finally {
            connectionPool.retrieve(connection);
            close(preparedStatement);
        }
    }

    @Override
    public void markOrderAsReady(int id) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = connectionPool.provide();
            preparedStatement = connection.prepareStatement(MARK_AS_READY);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
            throw new DAOException("Can't mark order as ready", e);
        } finally {
            connectionPool.retrieve(connection);
            close(preparedStatement);
        }
    }
}

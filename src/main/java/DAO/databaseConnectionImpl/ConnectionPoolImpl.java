package DAO.databaseConnectionImpl;

import DAO.ConnectionPool;
import DAO.DAOStringsStorage;
import DAO.DatabaseConfigReader;
import DAO.exception.DAOException;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import static DAO.DAOStringsStorage.*;

public class ConnectionPoolImpl implements ConnectionPool {

    private static final Logger LOGGER = Logger.getLogger(ConnectionPoolImpl.class);
    private final String DRIVER;
    private static boolean driverIsLoaded = false;
    private final BlockingQueue<Connection> availableConnections;
    private final BlockingQueue<Connection> takenConnections;

    public ConnectionPoolImpl(DatabaseConfigReader databaseConfigReader) {
        DRIVER = databaseConfigReader.getProperty(DAOStringsStorage.DRIVER);
        String url = databaseConfigReader.getProperty(URL);
        String username = databaseConfigReader.getProperty(USERNAME);
        String password = databaseConfigReader.getProperty(PASSWORD);
        int amountOfConnections = 50;

        availableConnections = new ArrayBlockingQueue<>(amountOfConnections);
        takenConnections = new ArrayBlockingQueue<>(amountOfConnections);

        try {
            loadJDBCDriver();
            for (int i = 0; i < amountOfConnections; i++) {
                availableConnections.add(getConnection(url, username, password));
            }
        } catch (DAOException e) {
            LOGGER.info("availableConnections.size() is " + availableConnections.size());
            LOGGER.info("takenConnections.size() is " + takenConnections.size());
        }
    }

    private void loadJDBCDriver() throws DAOException {
        if (!driverIsLoaded) {
            try {
                Class.forName(DRIVER);
                driverIsLoaded = true;
                LOGGER.info("MySQL driver is loaded");
            } catch (ClassNotFoundException e) {
                LOGGER.error("MySQL driver is loaded");
                throw new DAOException("MySQL driver is loaded");
            }
        }
    }

    private Connection getConnection(String url, String username, String password) throws DAOException {
        Connection newConnection;
        try {
            newConnection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            LOGGER.error("Couldn't connect to database");
            throw new DAOException("Failed connection to database", e);
        }
        return newConnection;
    }

    @Override
    public Connection provide() throws DAOException {
        Connection connection;
        try {
            connection = availableConnections.take();
            takenConnections.add(connection);
        } catch (InterruptedException e) {
            LOGGER.error("Cannot provide connection!");
            throw new DAOException("Cannot provide connection!", e);
        }
        LOGGER.info("ConnectionPool.provide()");
        LOGGER.info("ConnectionPool.availableConnections.size() is " + availableConnections.size());
        LOGGER.info("ConnectionPool.takenConnections.size() is " + takenConnections.size());
        return connection;
    }

    @Override
    public void retrieve(Connection connection) {
        if (Objects.nonNull(connection)) {
            takenConnections.remove(connection);
            availableConnections.add(connection);
        } else {
            LOGGER.info("ConnectionPool.retrieve(Connection connection)");
            LOGGER.info("connection is NULL");
        }
        LOGGER.info("ConnectionPool.availableConnections.size() is " + availableConnections.size());
        LOGGER.info("ConnectionPool.takenConnections.size() is " + takenConnections.size());
    }
}

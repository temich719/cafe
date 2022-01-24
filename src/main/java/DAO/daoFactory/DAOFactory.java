package DAO.daoFactory;

import DAO.ConnectionPool;
import DAO.DatabaseConfigReader;
import DAO.OrderDAO;
import DAO.ProductDAO;
import DAO.databaseConnectionImpl.ConnectionPoolImpl;
import DAO.databaseConnectionImpl.DatabaseConfigReaderImpl;
import DAO.impl.OrderDAOImpl;
import DAO.impl.ProductDAOImpl;

public class DAOFactory {

    private static final DatabaseConfigReader databaseConfigReader = new DatabaseConfigReaderImpl();
    private static final ConnectionPool connectionPool = new ConnectionPoolImpl(databaseConfigReader);

    private static final DAOFactory INSTANCE = new DAOFactory();
    private final OrderDAO orderDAO;
    private final ProductDAO productDAO;

    public DAOFactory() {
        this.orderDAO = new OrderDAOImpl(connectionPool);
        this.productDAO = new ProductDAOImpl(connectionPool);
    }

    public OrderDAO getOrderDAO() {
        return orderDAO;
    }

    public ProductDAO getProductDAO() {
        return productDAO;
    }

    public static DAOFactory getINSTANCE() {
        return INSTANCE;
    }
}

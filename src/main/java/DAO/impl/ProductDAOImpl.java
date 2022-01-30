package DAO.impl;

import DAO.AbstractDAO;
import DAO.ConnectionPool;
import DAO.ProductDAO;
import DAO.domain.Page;
import DAO.domain.Product;
import DAO.exception.DAOException;
import DAO.util.OffsetCalculator;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static DAO.DAOStringsStorage.*;

public class ProductDAOImpl extends AbstractDAO implements ProductDAO {

    private static final String SELECT_PAGE_OF_BREADS = "SELECT id, dishName, price, picture FROM products ORDER BY id LIMIT ? OFFSET ?;";
    private static final String SELECT_COUNT_OF_PRODUCTS = "SELECT count(*) FROM products;";
    private static final String SELECT_PAGE_OF_BREAD_BY_CATEGORY = "SELECT id, dishName, price, picture FROM products WHERE category = ? ORDER BY id LIMIT ? OFFSET ?;";
    private static final String SELECT_DISH_BY_ID = "SELECT * FROM products WHERE id = ?;";
    private static final String ADD_PRODUCT = "INSERT INTO products(id, dishName, price, description, category, picture) values(?, ?, ?, ?, ?, ?);";
    private static final String DELETE_PRODUCT = "DELETE FROM products WHERE id = ?;";
    private static final String UPDATE_PRODUCT_DESCRIPTION = "UPDATE products SET dishName = ?, price = ?, description = ?, category = ?, picture = ? WHERE id = ?;";

    private static final int LIMIT = 9;
    private static final Logger LOGGER = Logger.getLogger(ProductDAOImpl.class);

    private final OffsetCalculator offsetCalculator = OffsetCalculator.getINSTANCE();

    public ProductDAOImpl(ConnectionPool connectionPool1) {
        super(connectionPool1);
    }

    @Override
    public Page<Product> getPageOfBreads(String numberOfPage) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            List<Product> products = new ArrayList<>();
            connection = connectionPool.provide();
            preparedStatement = connection.prepareStatement(SELECT_PAGE_OF_BREADS);
            preparedStatement.setInt(1, LIMIT);
            preparedStatement.setInt(2, offsetCalculator.calculateOffset(numberOfPage, LIMIT));
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                final Product product = new Product(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4));
                products.add(product);
            }
            return new Page<>(products, getNumbersOfPagesOfProducts());
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
            throw new DAOException("Can't get page of breads", e);
        } finally {
            connectionPool.retrieve(connection);
            close(resultSet, preparedStatement);
        }
    }

    @Override
    public Page<Product> getPageOfBuns(String numberOfPage) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = connectionPool.provide();
            preparedStatement = connection.prepareStatement(SELECT_PAGE_OF_BREAD_BY_CATEGORY);
            preparedStatement.setString(1, BUN);
            preparedStatement.setInt(2, LIMIT);
            preparedStatement.setInt(3, offsetCalculator.calculateOffset(numberOfPage, LIMIT));
            resultSet = preparedStatement.executeQuery();
            List<Product> products = new ArrayList<>();
            while (resultSet.next()) {
                final Product product = new Product(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4));
                products.add(product);
            }
            return new Page<>(products, getNumbersOfPagesOfProducts());
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
            throw new DAOException("Can't get list of buns", e);
        } finally {
            connectionPool.retrieve(connection);
            close(resultSet, preparedStatement);
        }
    }

    @Override
    public Page<Product> getPageOfClassicalBread(String numberOfPage) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = connectionPool.provide();
            preparedStatement = connection.prepareStatement(SELECT_PAGE_OF_BREAD_BY_CATEGORY);
            preparedStatement.setString(1, CLASSICAL);
            preparedStatement.setInt(2, LIMIT);
            preparedStatement.setInt(3, offsetCalculator.calculateOffset(numberOfPage, LIMIT));
            resultSet = preparedStatement.executeQuery();
            List<Product> products = new ArrayList<>();
            while (resultSet.next()) {
                final Product product = new Product(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4));
                products.add(product);
            }
            return new Page<>(products, getNumbersOfPagesOfProducts());
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
            throw new DAOException("Can't get list of classical bread");
        } finally {
            connectionPool.retrieve(connection);
            close(resultSet, preparedStatement);
        }
    }

    @Override
    public Page<Product> getPageOfEliteBread(String numberOfPage) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = connectionPool.provide();
            preparedStatement = connection.prepareStatement(SELECT_PAGE_OF_BREAD_BY_CATEGORY);
            preparedStatement.setString(1, ELITE);
            preparedStatement.setInt(2, LIMIT);
            preparedStatement.setInt(3, offsetCalculator.calculateOffset(numberOfPage, LIMIT));
            resultSet = preparedStatement.executeQuery();
            List<Product> products = new ArrayList<>();
            while (resultSet.next()) {
                final Product product = new Product(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4));
                products.add(product);
            }
            return new Page<>(products, getNumbersOfPagesOfProducts());
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
            throw new DAOException("Can't get list of elite bread");
        } finally {
            connectionPool.retrieve(connection);
            close(resultSet, preparedStatement);
        }
    }

    @Override
    public Product getDishByID(int id) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Product product = null;
        try {
            connection = connectionPool.provide();
            preparedStatement = connection.prepareStatement(SELECT_DISH_BY_ID);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                product = new Product(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6));
            }
            return product;
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
            throw new DAOException("Can't get dish by ID", e);
        } finally {
            connectionPool.retrieve(connection);
            close(resultSet, preparedStatement);
        }
    }

    @Override
    public void addProduct(Product product) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = connectionPool.provide();
            preparedStatement = connection.prepareStatement(ADD_PRODUCT);
            preparedStatement.setInt(1, product.getId());
            preparedStatement.setString(2, product.getDishName());
            preparedStatement.setString(3, product.getPrice());
            preparedStatement.setString(4, product.getDescription());
            preparedStatement.setString(5, product.getCategory());
            preparedStatement.setString(6, product.getPicture());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
            throw new DAOException("Can't add product", e);
        } finally {
            connectionPool.retrieve(connection);
            close(preparedStatement);
        }
    }

    @Override
    public void deleteProductByID(int id) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = connectionPool.provide();
            preparedStatement = connection.prepareStatement(DELETE_PRODUCT);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
            throw new DAOException("Can't delete product", e);
        } finally {
            connectionPool.retrieve(connection);
            close(preparedStatement);
        }
    }

    @Override
    public void changeProductDescription(Product product) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = connectionPool.provide();
            preparedStatement = connection.prepareStatement(UPDATE_PRODUCT_DESCRIPTION);
            preparedStatement.setString(1, product.getDishName());
            preparedStatement.setString(2, product.getPrice());
            preparedStatement.setString(3, product.getDescription());
            preparedStatement.setString(4, product.getCategory());
            preparedStatement.setString(5, product.getPicture());
            preparedStatement.setInt(6, product.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
            throw new DAOException("Can't update product info", e);
        } finally {
            connectionPool.retrieve(connection);
            close(preparedStatement);
        }
    }

    private List<String> getNumbersOfPagesOfProducts() throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = connectionPool.provide();
            preparedStatement = connection.prepareStatement(SELECT_COUNT_OF_PRODUCTS);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            int count = resultSet.getInt(1);
            int countOfPages = (int) Math.ceil((double) count / LIMIT);
            List<String> numbers = new ArrayList<>();
            for (int i = 0; i < countOfPages; i++) {
                numbers.add(String.valueOf(i + 1));
            }
            return numbers;
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            connectionPool.retrieve(connection);
            close(resultSet, preparedStatement);
        }
    }
}

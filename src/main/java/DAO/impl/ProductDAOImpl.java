package DAO.impl;

import DAO.AbstractDAO;
import DAO.ConnectionPool;
import DAO.ProductDAO;
import DAO.domain.Page;
import DAO.domain.Product;

public class ProductDAOImpl extends AbstractDAO implements ProductDAO {

    public ProductDAOImpl(ConnectionPool connectionPool1) {
        super(connectionPool1);
    }

    @Override
    public Page<Product> getPageOfBreads(String numberOfPage) {
        return null;
    }

    @Override
    public Page<Product> getPageOfBuns(String numberOfPage) {
        return null;
    }

    @Override
    public Page<Product> getPageOfClassicalBread(String numberOfPage) {
        return null;
    }

    @Override
    public Page<Product> getPageOfEliteBread(String numberOfPage) {
        return null;
    }

    @Override
    public Product getDishByID(int id) {
        return null;
    }

    @Override
    public void addProduct(Product product) {

    }

    @Override
    public void deleteProductByID(int id) {

    }

    @Override
    public void changeProductDescription(int id, Product product) {

    }
}

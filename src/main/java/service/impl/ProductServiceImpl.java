package service.impl;

import DAO.ProductDAO;
import DAO.daoFactory.DAOFactory;
import DAO.domain.Page;
import DAO.domain.Product;
import DAO.exception.DAOException;
import org.apache.log4j.Logger;
import service.ProductService;
import service.exception.ServiceException;

public class ProductServiceImpl implements ProductService {

    private static final Logger LOGGER = Logger.getLogger(ProductServiceImpl.class);

    private final DAOFactory daoFactory = DAOFactory.getINSTANCE();
    private final ProductDAO productDAO = daoFactory.getProductDAO();

    @Override
    public Page<Product> getPageOfBreads(String numberOfPage) throws ServiceException {
        try {
            return productDAO.getPageOfBreads(numberOfPage);
        } catch (DAOException e) {
            LOGGER.error("Service Layer: " + e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public Page<Product> getPageOfBuns(String numberOfPage) throws ServiceException {
        try {
            return productDAO.getPageOfBuns(numberOfPage);
        } catch (DAOException e) {
            LOGGER.error("Service Layer: " + e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public Page<Product> getPageOfClassicalBread(String numberOfPage) throws ServiceException {
        try {
            return productDAO.getPageOfClassicalBread(numberOfPage);
        } catch (DAOException e) {
            LOGGER.error("Service Layer: " + e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public Page<Product> getPageOfEliteBread(String numberOfPage) throws ServiceException {
        try {
            return productDAO.getPageOfEliteBread(numberOfPage);
        } catch (DAOException e) {
            LOGGER.error("Service Layer: " + e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public Product getDishByID(int id) throws ServiceException {
        try {
            return productDAO.getDishByID(id);
        } catch (DAOException e) {
            LOGGER.error("Service Layer: " + e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public void addProduct(Product product) throws ServiceException {
        try {
            productDAO.addProduct(product);
        } catch (DAOException e) {
            LOGGER.error("Service Layer: " + e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public void deleteProductByID(int id) throws ServiceException {
        try {
            productDAO.deleteProductByID(id);
        } catch (DAOException e) {
            LOGGER.error("Service Layer: " + e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public void changeProductDescription(Product product) throws ServiceException {
        try {
            productDAO.changeProductDescription(product);
        } catch (DAOException e) {
            LOGGER.error("Service Layer: " + e.getMessage());
            throw new ServiceException(e);
        }
    }
}

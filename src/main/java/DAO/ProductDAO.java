package DAO;

import DAO.domain.Page;
import DAO.domain.Product;
import DAO.exception.DAOException;

public interface ProductDAO {
    Page<Product> getPageOfBreads(String numberOfPage) throws DAOException;

    Page<Product> getPageOfBuns(String numberOfPage) throws DAOException;

    Page<Product> getPageOfClassicalBread(String numberOfPage) throws DAOException;

    Page<Product> getPageOfEliteBread(String numberOfPage) throws DAOException;

    Product getDishByID(int id) throws DAOException;

    void addProduct(Product product) throws DAOException;

    void deleteProductByID(int id) throws DAOException;

    void changeProductDescription(Product product) throws DAOException;

}

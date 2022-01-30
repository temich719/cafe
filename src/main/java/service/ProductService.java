package service;

import DAO.domain.Page;
import DAO.domain.Product;
import service.exception.ServiceException;

public interface ProductService {
    Page<Product> getPageOfBreads(String numberOfPage) throws ServiceException;

    Page<Product> getPageOfBuns(String numberOfPage) throws ServiceException;

    Page<Product> getPageOfClassicalBread(String numberOfPage) throws ServiceException;

    Page<Product> getPageOfEliteBread(String numberOfPage) throws ServiceException;

    Product getDishByID(int id) throws ServiceException;

    void addProduct(Product product) throws ServiceException;

    void deleteProductByID(int id) throws ServiceException;

    void changeProductDescription(Product product) throws ServiceException;
}

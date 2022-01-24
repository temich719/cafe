package service.impl;

import DAO.domain.Page;
import DAO.domain.Product;
import service.ProductService;

public class ProductServiceImpl implements ProductService {
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

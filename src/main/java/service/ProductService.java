package service;

import DAO.domain.Page;
import DAO.domain.Product;

public interface ProductService {
    Page<Product> getPageOfBreads(String numberOfPage);

    Page<Product> getPageOfBuns(String numberOfPage);

    Page<Product> getPageOfClassicalBread(String numberOfPage);

    Page<Product> getPageOfEliteBread(String numberOfPage);

    Product getDishByID(int id);

    void addProduct(Product product);

    void deleteProductByID(int id);

    void changeProductDescription(int id, Product product);
}

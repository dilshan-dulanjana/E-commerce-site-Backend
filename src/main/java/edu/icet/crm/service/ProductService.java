package edu.icet.crm.service;

import edu.icet.crm.model.Product;

import java.util.List;

public interface ProductService {
    Product persist(Product product);

    List<Product> getAllProducts();


    Product updateProduct(Product product);

    void deleteProduct(Long id);

    Product searchProduct(Long id);

    List<Product> getProductsByCategory();
}

package edu.icet.crm.service;

import edu.icet.crm.model.Product;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public interface ProductService {
    Product persist(Product product);

    List<Product> getAllProducts();


    Product updateProduct(Product product);

    void deleteProduct(Long id);

    Product searchProduct(Long id);

    List<Product> getProductsByCategory(String category);

    Integer getProductCount();

    HashMap<String, Object> updateRedCountAndRetrieve();
}

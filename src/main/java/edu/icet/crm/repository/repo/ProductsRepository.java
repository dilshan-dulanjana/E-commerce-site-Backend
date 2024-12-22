package edu.icet.crm.repository.repo;

import edu.icet.crm.entity.ProductEntity;

import java.util.HashMap;
import java.util.List;

public interface ProductsRepository {
    List<ProductEntity> getProductsByCategory(String category);

    Integer getProductCount();

    HashMap<String, Object> updateRedCountAndRetrieve();
}

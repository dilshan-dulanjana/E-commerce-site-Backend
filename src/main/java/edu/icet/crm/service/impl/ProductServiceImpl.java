package edu.icet.crm.service.impl;

import edu.icet.crm.entity.ProductEntity;
import edu.icet.crm.model.Product;
import edu.icet.crm.repository.ProductRepositoryJPa;
import edu.icet.crm.repository.repo.ProductsRepository;
import edu.icet.crm.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {
    private final ProductRepositoryJPa productRepositoryjpa;
    private final ModelMapper modelMapper;
    private final ProductsRepository productsRepository;

    @Override
    public Product persist(Product product) {
        ProductEntity save = productRepositoryjpa.save(
                modelMapper.map(product, ProductEntity.class));
        return modelMapper.map(
                save, Product.class);

    }

    @Override
    public List<Product> getAllProducts() {
        List<Product>productList = new ArrayList<>();
        productRepositoryjpa.findAll().forEach(entity->{
            productList.add(modelMapper.map(entity, Product.class));
        });
        return productList;
    }

    @Override
    public Product updateProduct(Product product) {
           ProductEntity save = productRepositoryjpa.save(
                modelMapper.map(product, ProductEntity.class));
        return modelMapper.map(
                save, Product.class);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepositoryjpa.deleteById(id);

    }

    @Override
    public Product searchProduct(Long id) {
        return modelMapper.map(
                productRepositoryjpa.findById(id), Product.class);
    }

    @Override
    public List<Product> getProductsByCategory(String category) {

        List<Product> productList= new ArrayList<>();
        
        List<ProductEntity>entityList= productsRepository.getProductsByCategory(category);

        entityList.forEach(entity->{

            productList.add(modelMapper.map(entity,Product.class));
        });

        return productList;
    }

    @Override
    public Integer getProductCount() {
       return productsRepository.getProductCount();
    }

    @Override
    public HashMap<String, Object> updateRedCountAndRetrieve() {
        return productsRepository.updateRedCountAndRetrieve();
    }
}

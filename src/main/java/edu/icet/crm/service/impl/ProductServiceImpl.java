package edu.icet.crm.service.impl;

import edu.icet.crm.entity.ProductEntity;
import edu.icet.crm.model.Product;
import edu.icet.crm.repository.ProductRepository;
import edu.icet.crm.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    @Override
    public Product persist(Product product) {
        ProductEntity save = productRepository.save(
                modelMapper.map(product, ProductEntity.class));
        return modelMapper.map(
                save, Product.class);

    }

    @Override
    public List<Product> getAllProducts() {
        List<Product>productList = new ArrayList<>();
        productRepository.findAll().forEach(entity->{
            productList.add(modelMapper.map(entity, Product.class));
        });
        return productList;
    }

    @Override
    public Product updateProduct(Product product) {
        ProductEntity save = productRepository.save(
                modelMapper.map(product, ProductEntity.class));
        return modelMapper.map(
                save, Product.class);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);

    }

    @Override
    public Product searchProduct(Long id) {
        return modelMapper.map(
                productRepository.findById(id), Product.class);
    }
}

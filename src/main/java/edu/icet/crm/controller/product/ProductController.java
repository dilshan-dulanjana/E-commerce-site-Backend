package edu.icet.crm.controller.product;


import edu.icet.crm.model.Product;
import edu.icet.crm.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class ProductController {

 private final   ProductService productService;

    @PostMapping("/add-product")
    public Product persist(@RequestBody Product product){

        return productService.persist(product);
    }

    @GetMapping("/get-allproduct")
    public List<Product>getAllProducts(){

        return productService.getAllProducts();
    }

    @PutMapping("/update-product")
    public Product updateProduct(@RequestBody Product product){

        return productService.updateProduct(product);
    }

    @DeleteMapping("/delete-product/{id}")
    public void deleteProduct(@PathVariable Long id){

        productService.deleteProduct(id);
    }
    @GetMapping("/search-product/{id}")
    public Product searchProduct(@PathVariable Long id){

        return productService.searchProduct(id);
    }


    @GetMapping("/getProductsByCategory/{catagory}")
    public List<Product> getProductsByCategory( @PathVariable String catagory){
        System.out.println(catagory);

        List<Product> productsByCategory = productService.getProductsByCategory(catagory);
        System.out.println(productsByCategory);
        return productsByCategory;
    }

    @GetMapping("/getProductCount")
    public Integer getProductCount(){
        return productService.getProductCount();

    }

    @GetMapping("/getRedCount")
   public HashMap<String, Object> updateRedCountAndRetrieve(){
        return productService.updateRedCountAndRetrieve();
    }


}

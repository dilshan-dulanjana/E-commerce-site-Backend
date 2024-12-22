package edu.icet.crm.repository.impl;

import edu.icet.crm.entity.ProductEntity;
import edu.icet.crm.repository.repo.ProductsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ProductRepositoryImpl implements ProductsRepository {
    private final JdbcTemplate jdbcTemplate;
    @Override
    public List<ProductEntity> getProductsByCategory(String category) {
        String sql = "SELECT * FROM product WHERE catagory = ?";


       return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ProductEntity.class), category);


    }

    @Override
    public Integer getProductCount() {
        String sql =" SELECT COUNT(*) FROM product ";
        return   jdbcTemplate.queryForObject(sql,
                Integer.class);


    }

    public HashMap<String, Object> updateRedCountAndRetrieve() {
        HashMap<String, Object> result = new HashMap<>();

        try {
            //first check the red-count is correct
            String updateRedCountfirst = "UPDATE product SET red_count = false WHERE qty > 10 AND red_count = true";
            jdbcTemplate.update(updateRedCountfirst);
            // Step 1: Update `red_count` for products where qty < 10
            String updateRedCount = "UPDATE product SET red_count = true WHERE qty < 10 AND red_count = false";
            jdbcTemplate.update(updateRedCount);

            // Step 2: Retrieve products with red_count = true
            String getRedCountProducts = """
            SELECT id, product_name, qty
            FROM product
            WHERE red_count = true
        """;

            List<Map<String, Object>> redCountProducts = jdbcTemplate.queryForList(getRedCountProducts);

            // Step 3: Map the results to the HashMap
            result.put("Red_Count_Products", redCountProducts);
        } catch (Exception e) {
            throw new RuntimeException("Error updating and retrieving red count products", e);
        }

        return result;
    }

}

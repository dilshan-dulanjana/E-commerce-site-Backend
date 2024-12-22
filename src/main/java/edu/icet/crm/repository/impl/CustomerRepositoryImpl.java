package edu.icet.crm.repository.impl;

import edu.icet.crm.model.Bill;
import edu.icet.crm.model.BillItem;
import edu.icet.crm.repository.repo.CustomersRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
@RequiredArgsConstructor
public class CustomerRepositoryImpl implements CustomersRepository {
   private final JdbcTemplate jdbcTemplate;



    @Override
    public boolean logingCheck(String email, String password) {

        String sql = "SELECT COUNT(*) FROM customer WHERE email = ? AND password = ?";
        Integer count = jdbcTemplate.queryForObject(sql,
                new Object[]{email, password},
                Integer.class);
        return count != null && count > 0;

    }

    @Override
    @Transactional
    public HashMap<String, Object> makeBill(Bill bill, List<BillItem> billItems) {
        HashMap<String, Object> result = new HashMap<>();

        try {
            // Step 1: Insert Bill and retrieve Bill_Id
            String sqlBill = "INSERT INTO Bill (customer_ID, Bill_Total) VALUES (?, ?)";
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(sqlBill, Statement.RETURN_GENERATED_KEYS);
                ps.setLong(1, bill.getCustomer_Id());
                ps.setDouble(2, bill.getBill_Total());
                return ps;
            }, keyHolder);

            // Retrieve the generated Bill_Id
            Long billId = keyHolder.getKey().longValue();

            // Step 2: Insert BillItems and Update Product Quantity
            String sqlBillItem = "INSERT INTO BillItem (Bill_Id, product_ID, Qty, Total_Amount) VALUES (?, ?, ?, ?)";
            String updateProductQty = "UPDATE product SET qty = qty - ? WHERE id = ?";
            String updateRedCount = "UPDATE product SET red_count = true WHERE id = ? AND qty < 10";

            for (BillItem billItem : billItems) {
                // Insert BillItem
                jdbcTemplate.update(sqlBillItem, billId, billItem.getProduct_ID(), billItem.getQty(), billItem.getTotal_Amount());

                // Update Product Quantity
                jdbcTemplate.update(updateProductQty, billItem.getQty(), billItem.getProduct_ID());

                // Check and Update `red_count` if qty < 10
                jdbcTemplate.update(updateRedCount, billItem.getProduct_ID());
            }

            // Step 3: Retrieve and Map Bill Details
            String getBill = """
            SELECT 
                    b.Bill_Id,
                    b.customer_ID,
                    c.name as customer_name,
                    p.id as product_id,
                    p.product_name,
                    p.barcode,
                    bi.Qty,
                    bi.Total_Amount,
                    b.Bill_Total
                FROM
                    Bill b
                JOIN
                    BillItem bi ON b.Bill_Id = bi.Bill_Id
                JOIN
                    customer c ON b.customer_ID = c.id
                JOIN
                    product p ON bi.product_ID = p.id
                WHERE
                    b.Bill_Id = ?
        """;

            List<Map<String, Object>> billDetails = jdbcTemplate.queryForList(getBill, billId);

            // Step 4: Map Data to HashMap
            result.put("Bill_Id", billId);
            result.put("Customer_Details", billDetails.get(0).get("customer_name"));
            result.put("Items", billDetails);

        } catch (Exception e) {
            throw new RuntimeException("Error creating bill", e);
        }

        return result;
    }





}

package edu.icet.crm.repository.impl;

import edu.icet.crm.repository.repo.CustomersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


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
}

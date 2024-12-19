package edu.icet.crm.service;

import edu.icet.crm.model.Customer;

import java.util.List;

public interface CustomerService {
    Customer persist(Customer customer);

    List<Customer> getAllCustomers();

    Customer updateCustomer(Customer customer);

    void deleteCustomer(Long id);

    Customer searchCustomer(Long id);

    boolean logingCheck(String email, String password);
}

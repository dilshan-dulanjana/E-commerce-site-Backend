package edu.icet.crm.service.impl;


import edu.icet.crm.entity.CustomerEntity;
import edu.icet.crm.model.Customer;
import edu.icet.crm.repository.CustomerRepository;
import edu.icet.crm.repository.repo.CustomersRepository;
import edu.icet.crm.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor

public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;
    private final CustomersRepository customersRepository;
    @Override
    public Customer persist(Customer customer) {
        CustomerEntity save = customerRepository.save(
                modelMapper.map(customer, CustomerEntity.class));
        return modelMapper.map(save, Customer.class);
    }

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer>customerList = new ArrayList<>();
        customerRepository.findAll().forEach(entity->{
            customerList.add(modelMapper.map(entity, Customer.class));
        });
        return customerList;
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        CustomerEntity save = customerRepository.save(
                modelMapper.map(customer, CustomerEntity.class));
        return modelMapper.map(save,Customer.class);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Customer searchCustomer(Long id) {
        return modelMapper.map(
                customerRepository.findById(id), Customer.class);
    }

    @Override
    public boolean logingCheck(String email, String password) {
        log.info(email,password);
        log.info(password);
        return  customersRepository.logingCheck(email,password);

    }
}

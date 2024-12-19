package edu.icet.crm.controller.customer;

import edu.icet.crm.model.Customer;
import edu.icet.crm.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("/add-customer")
    public Customer persist(@RequestBody Customer customer) {
        return customerService.persist(customer);
    }

    @GetMapping("/get-AllCustomers")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @PutMapping("/update-customer")
    public Customer updateCustomer(@RequestBody Customer customer) {
        return customerService.updateCustomer(customer);
    }

    @DeleteMapping("/delete-customer/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }

    @GetMapping("/search-customer/{id}")
    public Customer searchCustomer(@PathVariable Long id) {
        return customerService.searchCustomer(id);
    }

    @GetMapping("/checkLoging/{email}/{password}")
    public boolean logingCheck(@PathVariable String email, @PathVariable String password) {
      return  customerService.logingCheck(email,password);
    }
}


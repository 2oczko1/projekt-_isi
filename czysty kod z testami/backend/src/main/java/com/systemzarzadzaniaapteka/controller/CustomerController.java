package com.systemzarzadzaniaapteka.controller;

import com.systemzarzadzaniaapteka.model.Customer;
import com.systemzarzadzaniaapteka.repository.CustomerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // Pobierz wszystkich klientow
    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // Pobierz klienta po ID
    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    // Dodaj nowego klienta
    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    // Aktualizuj klienta
    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer customerDetails) {
        Customer customer = customerRepository.findById(id).orElse(null);
        if (customer == null) return null;
        customer.setEmail(customerDetails.getEmail());
        customer.setName(customerDetails.getName());
        customer.setPhone(customerDetails.getPhone());
        // inne pola
        return customerRepository.save(customer);
    }

    // Usun klienta
    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerRepository.deleteById(id);
    }
}

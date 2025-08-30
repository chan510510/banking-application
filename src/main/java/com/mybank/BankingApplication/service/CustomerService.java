package com.mybank.BankingApplication.service;

import com.mybank.BankingApplication.model.Customer;
import com.mybank.BankingApplication.repository.CustomerRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private  CustomerRepository customerRepository;
    // Get all customers
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
    // Get customer by id
    public Customer getCustomerById(Long id){
        return customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found with id "+ id));
    }

    public Customer createCustomer(Customer customer){
        return customerRepository.save(customer);
    }


public Customer updateCustomer(Long id, Customer customer) {
    Customer existing = customerRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Customer not found with id " + id));

    existing.setFirstName(customer.getFirstName());
    existing.setLastName(customer.getLastName());
    existing.setAddress(customer.getAddress());
    existing.setEmail(customer.getEmail());
    existing.setDateOfBirth(customer.getDateOfBirth());
    existing.setPhoneNumber(customer.getPhoneNumber());
    return customerRepository.save(existing);
}

public void deleteCustomer(Long id){
    if(!customerRepository.existsById(id)){
          throw new RuntimeException("Customer not found with id "+id);
    }
    customerRepository.deleteById(id);
}

}

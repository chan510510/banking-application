package com.mybank.BankingApplication.controller;

import com.mybank.BankingApplication.model.Customer;
import com.mybank.BankingApplication.repository.CustomerRepository;
import com.mybank.BankingApplication.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;


    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // GET all customers
    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    // GET by id
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id){
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

//    @PostMapping("/save")
//    public Customer  createCustomer(@RequestBody Customer customer){
//        return customerService.createCustomer(customer);
//    }

    @PostMapping("/save")
    public ResponseEntity<Customer>  createCustomer(@RequestBody Customer customer){
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.createCustomer(customer));
    }

//    @PutMapping("/{id}")
//    public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer customer){
//        return customerService.updateCustomer(id, customer);
//    }


    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customer){
        return ResponseEntity.ok(customerService.updateCustomer(id, customer));
    }


//    @DeleteMapping("/{id}")
//    public void deleteCustomer(@PathVariable Long id){
//        customerService.deleteCustomer(id);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id){

        customerService.deleteCustomer(id);
        return ResponseEntity.ok("Customer deleted successfully");

    }
}

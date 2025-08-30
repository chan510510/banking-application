package com.mybank.BankingApplication.controller;

import com.mybank.BankingApplication.model.Account;
import com.mybank.BankingApplication.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/account")
public class AccountController {
   @Autowired
    private  AccountService accountService;

//    AccountController(AccountService accountService){
//        this.accountService =  accountService;
//    }

    @GetMapping("/getDetails")
    public ResponseEntity<List<Account>> getAccountDetails(){
       return ResponseEntity.ok(accountService.getAccountDetails());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable Long id){
        return ResponseEntity.ok(accountService.getAccountById(id));
    }
    @PostMapping("/save")
    public ResponseEntity<Account> createAccount(@RequestBody Account account){
        return ResponseEntity.status(HttpStatus.CREATED).body(accountService.createAccount(account));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Account> updateAccount(@PathVariable Long id,@RequestBody Account account ){
        return ResponseEntity.ok(accountService.updateAccount(id,account));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(Long id){
        accountService.deleteAccount(id);
        return ResponseEntity.ok("Account deleted successfully");
    }
}

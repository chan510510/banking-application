package com.mybank.BankingApplication.service;

import com.mybank.BankingApplication.model.Account;
import com.mybank.BankingApplication.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private  AccountRepository accountRepository;

    public List<Account> getAccountDetails(){
       return accountRepository.findAll();
    }
    public Account getAccountById(Long id){
        return accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account not found with id "+id));
    }
    public Account createAccount(Account account){
        Account acc= new Account();
        acc.setAccountNumber(account.getAccountNumber());
        acc.setAccountType(account.getAccountType());
        acc.setBalance(account.getBalance());
        acc.setOpenedDate(account.getOpenedDate());
        acc.setActive(account.isActive());
        return accountRepository.save(acc);
    }
  public Account updateAccount(Long id,Account account){
        Account existing= accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found with "+id));
        existing.setAccountNumber(account.getAccountNumber());
        existing.setAccountType(account.getAccountType());
        existing.setBalance(account.getBalance());
        existing.setOpenedDate(account.getOpenedDate());
        existing.setActive(account.isActive());
        return accountRepository.save(existing);
  }
  public void deleteAccount(Long id){
        if(!accountRepository.existsById(id)){
            throw new RuntimeException("Account not found with id "+id);
        }
        accountRepository.deleteById(id);
  }
}

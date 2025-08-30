package com.mybank.BankingApplication.repository;

import com.mybank.BankingApplication.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}

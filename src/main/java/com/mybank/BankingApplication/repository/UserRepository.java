package com.mybank.BankingApplication.repository;

import com.mybank.BankingApplication.model.UserSignUp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserSignUp,Long> {

    UserSignUp findByUsername(String username);
}

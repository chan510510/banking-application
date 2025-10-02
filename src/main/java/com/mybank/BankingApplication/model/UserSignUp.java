package com.mybank.BankingApplication.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserSignUp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String userName;

    @Size(min = 8 ,max = 20, message = "password must contain at least 8 characters")
    private String passWord;

    @Email
    private String email;

    public UserSignUp(String userName, String passWord, String email) {
        this.userName=userName;
        this.passWord=passWord;
        this.email=email;
    }


}

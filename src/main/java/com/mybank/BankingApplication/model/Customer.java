package com.mybank.BankingApplication.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    @Email
    @Column(unique = true)
    private String email;

    @NotNull
    private String phoneNumber;

    @NotNull
    private LocalDate dateOfBirth;

    @NotNull
    private String address;
}

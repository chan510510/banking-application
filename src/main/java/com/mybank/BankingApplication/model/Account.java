package com.mybank.BankingApplication.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
@Entity
@Data
public class Account {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String accountNumber;

    @NotNull
    private String accountType;

    @NotNull
    private BigDecimal balance;

    @NotNull
    private LocalDate openedDate;
    private boolean isActive;

}

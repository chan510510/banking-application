package com.mybank.BankingApplication.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
@Entity
@Data
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String cardNumber;

    @NotNull
    private String cardType;

    @NotNull
    private LocalDate expiryDate;

    @NotNull
    private String cvv;

    private boolean isActive;

}

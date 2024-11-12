package com.example.ecommerce.model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class CreditCard extends Payment{
    private String cardNumber;
    private String cardExpiry;
    private String cardHolderName;
    private String cvv;
}

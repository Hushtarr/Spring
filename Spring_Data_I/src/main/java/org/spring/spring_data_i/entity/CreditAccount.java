package org.spring.spring_data_i.entity;

import jakarta.persistence.Entity;

import java.math.BigDecimal;
@Entity
public class CreditAccount extends Account
    {
    private BigDecimal creditLimit;
    }

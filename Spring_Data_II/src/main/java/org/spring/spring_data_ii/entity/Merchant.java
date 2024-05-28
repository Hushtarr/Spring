package org.spring.spring_data_ii.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name="merchants")
@NoArgsConstructor
@Data
public class Merchant
    {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String code;
    private BigDecimal transactionFee;
    private BigDecimal commissionRate;
    private Integer payoutDelayCount;

    // can we say it's like dependency injection ?
    @OneToMany(mappedBy = "merchant") // purpose is create foreign kye
//    class merchant -> so we can say one merchant has many payment
    //in one to many relationship,ownership belongs to many side
    private List<Payment> paymentList;
    //if we want to has a / inheritance relationship ,then we can inject the entity we want,
    // for get sth belong in child class through parent class
    // if not we dont need to inject / annotation one to many etc...
    public Merchant(String name, String code, BigDecimal transactionFee, BigDecimal commissionRate, Integer payoutDelayCount)
        {
        this.name = name;
        this.code = code;
        this.transactionFee = transactionFee;
        this.commissionRate = commissionRate;
        this.payoutDelayCount = payoutDelayCount;
        }
    }

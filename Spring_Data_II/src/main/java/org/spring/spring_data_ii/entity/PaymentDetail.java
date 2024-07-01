package org.spring.spring_data_ii.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="payment_details")
@NoArgsConstructor
@Data
public class PaymentDetail
    {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private BigDecimal merchantPayoutAmount;
    private BigDecimal commissionAmount;

    @OneToOne(mappedBy = "paymentDetail")
    @JoinColumn(name = "joined column")
    private Payment payment;
    //is not make sense if we create parent class through child class
    // but to show how mappedBy working
    //mappedBy basically saying that do not create new column in the current class which is being mapped

    @Column(columnDefinition = "Date")
    private LocalDate payoutDate;

    public PaymentDetail(BigDecimal merchantPayoutAmount, BigDecimal commissionAmount, LocalDate payoutDate)
        {
        this.merchantPayoutAmount = merchantPayoutAmount;
        this.commissionAmount = commissionAmount;
        this.payoutDate = payoutDate;
        }
    }

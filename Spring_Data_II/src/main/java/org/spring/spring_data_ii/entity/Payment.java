package org.spring.spring_data_ii.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.spring.spring_data_ii.enums.Status;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Data
@Table(name="payments")
public class Payment
    {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "Date")
    private LocalDate createdDate;

    private BigDecimal amount;

    @Enumerated(EnumType.STRING) // if not,it will be saved as string in database
    private Status paymentStatus;

    @OneToOne
    @JoinColumn(name = "payment_detail_id")
    private PaymentDetail paymentDetail;

    public Payment(LocalDate createdDate, BigDecimal amount, Status paymentStatus)
        {// no id,buz it provided  automatically
        this.createdDate = createdDate;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
        }
    }

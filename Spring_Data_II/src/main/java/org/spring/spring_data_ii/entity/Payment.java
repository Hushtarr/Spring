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

   /* @OneToOne(cascade = CascadeType.ALL) //foreign key from other table,
    // (content) is for connect the two class then perform same operation

    */
    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name = "joined column") // rename method
    private PaymentDetail paymentDetail;

    @ManyToOne //class Payment -> so we can say many payment has one merchant
    private Merchant merchant;
    // if can not create foreign key,then it will create third table for merging to column

    public Payment(LocalDate createdDate, BigDecimal amount, Status paymentStatus)
        {// no id,buz it provided  automatically
        this.createdDate = createdDate;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
        }
    }

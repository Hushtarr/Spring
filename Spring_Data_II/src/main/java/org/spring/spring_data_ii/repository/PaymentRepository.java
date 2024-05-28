package org.spring.spring_data_ii.repository;

import org.spring.spring_data_ii.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long>
    {
    }

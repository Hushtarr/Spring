package org.spring.spring_data_ii.repository;

import org.spring.spring_data_ii.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Long>
    {
    }

package org.spring.spring_data_ii.repository;

import org.spring.spring_data_ii.entity.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MerchantRepository extends JpaRepository<Merchant,Long>
    {
    }

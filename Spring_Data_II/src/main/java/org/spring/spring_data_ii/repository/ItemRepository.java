package org.spring.spring_data_ii.repository;

import org.spring.spring_data_ii.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Long>
    {
    }

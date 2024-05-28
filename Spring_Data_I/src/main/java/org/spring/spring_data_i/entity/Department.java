package org.spring.spring_data_i.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Department extends BaseEntity
    {
    private String department;
    private String division;
    }

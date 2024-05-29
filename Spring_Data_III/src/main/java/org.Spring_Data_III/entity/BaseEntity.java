package org.Spring_Data_III.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;


@MappedSuperclass // as a parent class for other entities
public class BaseEntity
    {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    }

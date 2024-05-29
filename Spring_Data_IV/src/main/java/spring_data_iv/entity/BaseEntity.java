package spring_data_iv.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass

public class BaseEntity
    {
    @Id
    private Integer id;
    }

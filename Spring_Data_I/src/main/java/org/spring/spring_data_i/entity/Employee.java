package org.spring.spring_data_i.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jdk.jfr.Enabled;

@Entity
public class Employee
    {
    @Id
    private String name;
    private int id;
    }

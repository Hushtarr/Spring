package org.Spring_Data_III.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Genre extends BaseEntity
    {
    private String name;
    }

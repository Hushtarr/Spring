package org.Spring_Data_III.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Cinema extends BaseEntity
    {
    private String name;
    private String sponsoredName;
    @ManyToOne(fetch = FetchType.LAZY) //foreign key should be created in 'many' side
    private Location location;
    }

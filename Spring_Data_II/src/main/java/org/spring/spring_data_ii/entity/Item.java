package org.spring.spring_data_ii.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "items")
public class Item
    {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String code;

    @ManyToMany(mappedBy = "items")
    private List<Cart> cart;
    // no need for two new columns so mapped here for create only in this side
    public Item(String name, String code)
        {
        this.name = name;
        this.code = code;
        }
    }

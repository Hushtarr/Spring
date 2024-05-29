package org.Spring_Data_III.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.Spring_Data_III.enums.UserRole;

@Entity
@Data
@NoArgsConstructor
@Table(name = "account_details")
public class Account extends BaseEntity
    {
    private String name;
    private String address;
    private String country;
    private String state;
    private String city;
    private String postalCode;
    private Integer age;
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @OneToOne(mappedBy = "account") // this annotation it's going to create a foreign key in current  table (current  class)
    private User user;

    }

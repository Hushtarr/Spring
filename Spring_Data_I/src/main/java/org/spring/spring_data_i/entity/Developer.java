package org.spring.spring_data_i.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.spring.spring_data_i.enums.Gender;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "developerTeam")
public class Developer extends BaseEntity
    {
    private String firstName;
    private String lastName;
    private String email;
    @Column(columnDefinition = "Date")
    private LocalDate hireDate;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private Integer salary;
    }

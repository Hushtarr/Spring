package org.spring.spring_data_i.entity;

import jakarta.persistence.*;
import org.spring.spring_data_i.enums.Gender;

import java.time.LocalDate;

@Entity
@Table(name = "students")
public class Student
    {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    @Column(name = "Student_FirstName")
    private String firstName;

    @Column(name="Student_LastName")
    private String lastName;

    private String email;

    @Column(columnDefinition = "DATE")
    private LocalDate BirthDate;

    @Column(columnDefinition = "TIME")
    private LocalDate BirthTime;

    @Column(columnDefinition="TIMESTAMP")
    private LocalDate BirthDateTime;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Transient
    private String city;
    }

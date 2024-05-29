package spring_data_iv.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring_data_iv.enums.Gender;

import java.time.LocalDate;

@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
public class Employee extends BaseEntity
    {
        private String firstName;
        private String lastName;
        private String email;
        private Integer salary;
        private LocalDate hireDate;


        @ManyToOne
        @JoinColumn(name = "department")
        private Department department;

        @ManyToOne
        @JoinColumn(name = "region_id")
        private Region region;


        @Enumerated(EnumType.STRING)
        private Gender gender;



    }

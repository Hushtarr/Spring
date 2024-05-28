package org.spring.spring_data_i.repository;

import org.spring.spring_data_i.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>
    {
    }

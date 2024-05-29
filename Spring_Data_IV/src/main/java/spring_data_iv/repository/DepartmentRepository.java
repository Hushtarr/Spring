package spring_data_iv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring_data_iv.entity.Department;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, String>
    {
        List<Department> findByDepartment(String department);
        List<Department> findDepartmentByDivision(String division);
        List<Department> findAllByDepartmentEndingWith(String division);
        List<Department> findTop3ByDepartmentEndingWith(String division);

    }

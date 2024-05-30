package spring_data_iv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import spring_data_iv.entity.Employee;
import java.util.List;
// drive query

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
    List<Employee> findByFirstNameContains(String name);
    List<Employee> findByEmailContains(String email);
    List<Employee> findByFirstNameStartsWith(String name);
    List<Employee> findBySalaryGreaterThan(Integer salary);
    List<Employee> findDistinctByFirstName(String name);


    // JPQL query

    @Query("SELECT employee FROM Employee employee where employee.firstName='Berrie' ")
    Employee findEmployeeByJPQL();
    //firstName=Berrie, lastName=Manueau, email=bmanueau0@dion.ne.jp,

    @Query("SELECT employee.salary FROM Employee employee where employee.email='amcnee1@google.es' ")
    Integer findSalaryByJPQL();
    // firstName=Aeriell, lastName=McNee, email=amcnee1@google.es, salary=56752,
    }

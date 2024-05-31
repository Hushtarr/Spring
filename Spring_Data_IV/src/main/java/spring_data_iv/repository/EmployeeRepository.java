package spring_data_iv.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import spring_data_iv.entity.Department;
import spring_data_iv.entity.Employee;
import spring_data_iv.enums.Gender;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
    // drive query

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

    @Query("select e.firstName from Employee e where e.salary > ?1")
    List<String> retireBySalaryGraterThen(Integer salary);

    @Query("select e.firstName from Employee e where e.salary = ?1")
    List<String> retireBySalaryIs(Integer salary);

    @Query("select e.firstName from Employee e where e.salary between ?1 and ?2")
    List<String> retireBySalaryBetween(Integer salary1, Integer salary2);

    @Query("select e.firstName from Employee e where e.email is null ")
    List<String> retireByEmailIsNull();

    @Query("select e.firstName from Employee e order by  e.firstName desc ")
    List<String> retireByDesc(Pageable pageable);

    // named query


    @Query("select e.firstName from Employee e where e.salary = :salary")
    List<String> retireByParam(@Param("salary") Integer parameter);

    @Query("select e.firstName from Employee e where e.gender = :gender and e.department.department = :department")
    List<String> retireByNamedQuery(@Param("gender") Gender gender, @Param("department") String department);


    // native query

    @Query(value="select first_name from  employees where  department='Movies' order by first_name asc ", nativeQuery = true)
    List<String> retireByDepartmentMovies();

    @Query(value="select first_name from employees where department='Movies' and gender='M' order by first_name asc ", nativeQuery = true)
    List<String> retireByEmailIsNullAndDepartment();

    @Query(value="select count(*) from employees where  email is null and department='Movies' and gender='M'", nativeQuery = true)
    int abc();


    }

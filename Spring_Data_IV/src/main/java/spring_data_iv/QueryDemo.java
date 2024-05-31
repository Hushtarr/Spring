package spring_data_iv;

import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import spring_data_iv.entity.Department;
import spring_data_iv.enums.Gender;
import spring_data_iv.repository.CourseRepository;
import spring_data_iv.repository.DepartmentRepository;
import spring_data_iv.repository.EmployeeRepository;
import spring_data_iv.repository.RegionRepository;

import java.util.Arrays;

@Component
public class QueryDemo implements CommandLineRunner
    {
    private final RegionRepository regionRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;
    private final CourseRepository courseRepository;

    public QueryDemo(RegionRepository regionRepository, DepartmentRepository departmentRepository, EmployeeRepository employeeRepository, CourseRepository courseRepository)
        {
            this.regionRepository = regionRepository;
            this.departmentRepository = departmentRepository;
            this.employeeRepository = employeeRepository;
            this.courseRepository = courseRepository;
        }



    @Override
    public void run(String... args) throws Exception
        {
            System.out.println("finded regions: " + regionRepository.findByCountry("Canada"));
            System.out.println("finded regions: " + regionRepository.findByCountryContaining("United"));
            System.out.println("finded regions: " + regionRepository.findByCountryContainsOrderByRegion("United"));
            System.out.println("finded regions: " + regionRepository.findTopByCountry("Canada"));
            System.out.println("finded regions: " + regionRepository.findTop2ByRegionOrderByCountryAsc("Canada"));


            System.out.println("finded department: " + departmentRepository.findByDepartment("Furniture"));
            System.out.println("finded department:"+departmentRepository.findDepartmentByDivision("Health"));
            System.out.println("finded department:"+departmentRepository.findAllByDepartmentEndingWith("e"));
            System.out.println("finded department:"+departmentRepository.findAll());
            System.out.println("finded department:"+departmentRepository.findTop3ByDepartmentEndingWith("e"));


            System.out.println("finded data:"+employeeRepository.findByFirstNameContains("H"));
            System.out.println("finded data:"+employeeRepository.findByEmailContains("google"));
            System.out.println("finded data:"+employeeRepository.findByFirstNameStartsWith("Michael"));
            System.out.println("finded data:"+employeeRepository.findBySalaryGreaterThan(150000));
            System.out.println("finded data:"+employeeRepository.findDistinctByFirstName("Aeriell"));
            System.out.println("finded data:"+employeeRepository.findEmployeeByJPQL());
            System.out.println("finded data:"+employeeRepository.findSalaryByJPQL());


            System.out.println("finded course:"+courseRepository.findCoursesByCategory("Spring"));
            System.out.println("finded course:"+courseRepository.findByCategoryOrderByName("Spring"));
            System.out.println("finded course:"+courseRepository.existsByName("Java"));
            System.out.println("finded course:"+courseRepository.countByCategory("Spring"));
            System.out.println("finded course:"+courseRepository.findCourseByDescriptionStartsWith("M"));


            System.out.println("finded course:"+courseRepository.retireByRate(4));
            System.out.println("finded course:"+courseRepository.retireByContains("Rapid"));


            System.out.println("finded employee:"+employeeRepository.retireBySalaryGraterThen(119674));
            System.out.println("finded employee:"+employeeRepository.retireBySalaryIs(119674));
            System.out.println("finded employee:"+employeeRepository.retireBySalaryBetween(119674,120000));
            System.out.println("finded employee:"+employeeRepository.retireByEmailIsNull());
            Pageable pageable = PageRequest.of(0, 10);
            System.out.println("finded employee:"+employeeRepository.retireByDesc(pageable));

            System.out.println("finded employee:"+employeeRepository.retireByDepartmentMovies());
            System.out.println("finded employee:"+employeeRepository.retireByEmailIsNullAndDepartment());
            System.out.println("finded employee:"+employeeRepository.abc());
            System.out.println("finded employee:"+employeeRepository.retireByParam(119674));
            System.out.println("finded employee:"+employeeRepository.retireByNamedQuery(Gender.M, "Movies"));

        }
    }

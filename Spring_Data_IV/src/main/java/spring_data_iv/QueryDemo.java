package spring_data_iv;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import spring_data_iv.repository.DepartmentRepository;
import spring_data_iv.repository.EmployeeRepository;
import spring_data_iv.repository.RegionRepository;

@Component
public class QueryDemo implements CommandLineRunner
    {
    private final RegionRepository regionRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    public QueryDemo(RegionRepository regionRepository, DepartmentRepository departmentRepository, EmployeeRepository employeeRepository)
        {
        this.regionRepository = regionRepository;
        this.departmentRepository = departmentRepository;
            this.employeeRepository = employeeRepository;
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
        }
    }

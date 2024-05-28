package org.spring.spring_data_i.boottrap;

import org.spring.spring_data_i.entity.Car;
import org.spring.spring_data_i.entity.Department;
import org.spring.spring_data_i.entity.Developer;
import org.spring.spring_data_i.enums.Gender;
import org.spring.spring_data_i.repository.CarRepository;
import org.spring.spring_data_i.repository.DepartmentRepository;
import org.spring.spring_data_i.repository.DeveloperRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DataGenerator implements CommandLineRunner
    {
    private final CarRepository carRepository;
    private final DepartmentRepository departmentRepository;
    private final DeveloperRepository developerRepository;

    public DataGenerator(CarRepository carRepository, DepartmentRepository departmentRepository, DeveloperRepository developerRepository)
        {
        this.carRepository = carRepository;
        this.departmentRepository = departmentRepository;
        this.developerRepository = developerRepository;
        }

    @Override
    public void run(String... args) throws Exception
        {
        Car c1 = new Car("Bmw","M3");
        Car c2 = new Car("Bmw","320");
        Car c3 = new Car("Bmw","116i");
        carRepository.save(c1);
        carRepository.save(c2);
        carRepository.save(c3);

        Department department1 = new Department("Engineering", "Software Development");
        Department department2 = new Department("Human Resources", "Employee Relations");
        Department department3 = new Department("Marketing", "Digital Marketing");
        Department department4 = new Department("Finance", "Corporate Finance");
        Department department5 = new Department("Sales", "Sales Operations");
        departmentRepository.save(department1);
        departmentRepository.save(department2);
        departmentRepository.save(department3);
        departmentRepository.save(department4);
        departmentRepository.save(department5);

        Developer developer1 = new Developer("John", "Doe", "john.doe@example.com", LocalDate.of(2020, 1, 15), Gender.MALE, 80000);
        Developer developer2 = new Developer("Jane", "Smith", "jane.smith@example.com", LocalDate.of(2019, 5, 20), Gender.FEMALE, 85000);
        Developer developer3 = new Developer("Bob", "Johnson", "bob.johnson@example.com", LocalDate.of(2018, 3, 10), Gender.MALE, 90000);
        Developer developer4 = new Developer("Alice", "Williams", "alice.williams@example.com", LocalDate.of(2021, 7, 5), Gender.FEMALE, 75000);
        Developer developer5 = new Developer("Charlie", "Brown", "charlie.brown@example.com", LocalDate.of(2022, 11, 30), Gender.MALE, 70000);
        developerRepository.save(developer1);
        developerRepository.save(developer2);
        developerRepository.save(developer3);
        developerRepository.save(developer4);
        developerRepository.save(developer5);

//        or

        List<Developer> developers = new ArrayList<>(Arrays.asList(developer1, developer2, developer3, developer4, developer5));
        List<Department> departments = new ArrayList<>(Arrays.asList(department1, department2, department3, department4, department5));
        developerRepository.saveAll(developers);
        departmentRepository.saveAll(departments);


        }
    }

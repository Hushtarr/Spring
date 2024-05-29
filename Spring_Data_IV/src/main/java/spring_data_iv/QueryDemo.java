package spring_data_iv;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import spring_data_iv.repository.DepartmentRepository;
import spring_data_iv.repository.RegionRepository;

@Component
public class QueryDemo implements CommandLineRunner
    {
    private final RegionRepository regionRepository;
    private final DepartmentRepository departmentRepository;

    public QueryDemo(RegionRepository regionRepository, DepartmentRepository departmentRepository)
        {
        this.regionRepository = regionRepository;
        this.departmentRepository = departmentRepository;
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
        }
    }

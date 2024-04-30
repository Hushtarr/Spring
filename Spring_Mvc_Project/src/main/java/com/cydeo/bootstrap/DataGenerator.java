package com.cydeo.bootstrap;

import com.cydeo.dto.RoleDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.enums.Gender;
import com.cydeo.service.RoleService;
import com.cydeo.service.UserService;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DataGenerator implements CommandLineRunner
    {
    private final RoleService roleService;
    private final UserService userService;

    public DataGenerator(RoleService roleService, UserService userService)
        {
        this.roleService = roleService;
        this.userService = userService;
        }

    @Override
    public void run(String... args) throws Exception
        {
        RoleDTO Admin = new RoleDTO(1L, "Admin");
        RoleDTO Manager = new RoleDTO(1L, "Manager");
        RoleDTO Employee = new RoleDTO(1L, "Employee");
        roleService.save(Admin);
        roleService.save(Manager);
        roleService.save(Employee);

        Faker faker = new Faker();
        UUID uuid = UUID.randomUUID();
        UserDTO u1=new UserDTO(faker.name().firstName(),faker.name().lastName(),faker.name().username(),uuid.toString(),true,faker.phoneNumber().toString(),Admin, Gender.Male);
        UserDTO u2=new UserDTO(faker.name().firstName(),faker.name().lastName(),faker.name().username(),uuid.toString(),true,faker.phoneNumber().toString(),Manager, Gender.Female);
        UserDTO u3=new UserDTO(faker.name().firstName(),faker.name().lastName(),faker.name().username(),uuid.toString(),true,faker.phoneNumber().toString(),Employee, Gender.Female);



        userService.save(u1);
        userService.save(u2);
        userService.save(u3);
        }


    }

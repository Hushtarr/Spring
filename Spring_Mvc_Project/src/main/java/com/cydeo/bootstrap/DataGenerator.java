package com.cydeo.bootstrap;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.RoleDTO;
import com.cydeo.dto.TaskDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.enums.Gender;
import com.cydeo.enums.Status;
import com.cydeo.service.ProjectService;
import com.cydeo.service.RoleService;
import com.cydeo.service.TaskService;
import com.cydeo.service.UserService;
import com.github.javafaker.Faker;
import com.sun.jdi.LongValue;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.UUID;

@Component
public class DataGenerator implements CommandLineRunner
    {
    private final RoleService roleService;
    private final UserService userService;
    private final ProjectService projectService;
    private final TaskService taskService;

    public DataGenerator(RoleService roleService, UserService userService, ProjectService projectService, TaskService taskService)
        {
        this.roleService = roleService;
        this.userService = userService;
        this.projectService = projectService;
        this.taskService = taskService;
        }

    @Override
    public void run(String... args) throws Exception
        {
        RoleDTO Admin = new RoleDTO(1L, "Admin");
        RoleDTO Manager = new RoleDTO(2L, "Manager");
        RoleDTO Employee = new RoleDTO(3L, "Employee");
        roleService.save(Admin);
        roleService.save(Manager);
        roleService.save(Employee);

        Faker faker = new Faker();
        UserDTO u1=new UserDTO(faker.name().firstName(),faker.name().lastName(),faker.internet().emailAddress(),"abc",true,"0991",Admin, Gender.MALE);
        UserDTO u2=new UserDTO(faker.name().firstName(),faker.name().lastName(),faker.internet().emailAddress(),"def",true,"0991",Manager, Gender.FEMALE);
        UserDTO u3=new UserDTO(faker.name().firstName(),faker.name().lastName(),faker.internet().emailAddress(),"ghi",true,"0991",Employee, Gender.FEMALE);
        UserDTO u4=new UserDTO("C","J","Its CJ","ghi",true,"0991",Manager, Gender.MALE);
        userService.save(u1);
        userService.save(u2);
        userService.save(u3);
        userService.save(u4);


        ProjectDTO p1=new ProjectDTO(faker.internet().domainName(),faker.internet().password(),u1, LocalDate.now(),LocalDate.now().plusDays(5),faker.programmingLanguage().toString(), Status.COMPLETE );
        ProjectDTO p2=new ProjectDTO(faker.internet().domainName(),faker.internet().password(),u2, LocalDate.now(),LocalDate.now().plusDays(5),faker.programmingLanguage().toString(), Status.IN_PROGRESS );
        ProjectDTO p3=new ProjectDTO(faker.internet().domainName(),faker.internet().password(),u3, LocalDate.now(),LocalDate.now().plusDays(5),faker.programmingLanguage().toString(), Status.OPEN );
        ProjectDTO p4=new ProjectDTO(faker.internet().domainName(),faker.internet().password(),u4, LocalDate.now(),LocalDate.now().plusDays(5),faker.programmingLanguage().toString(), Status.OPEN );
        projectService.save(p1);
        projectService.save(p2);
        projectService.save(p3);
        projectService.save(p4);


        TaskDTO t1=new TaskDTO(1L,p1,u1,faker.book().title(),faker.book().genre(),Status.OPEN,LocalDate.now());
        TaskDTO t2=new TaskDTO(2L,p2,u2,faker.book().title(),faker.book().genre(),Status.IN_PROGRESS,LocalDate.now());
        TaskDTO t3=new TaskDTO(3L,p3,u3,faker.book().title(),faker.book().genre(),Status.COMPLETE,LocalDate.now());
        TaskDTO t4=new TaskDTO(3L,p4,u4,faker.book().title(),faker.book().genre(),Status.COMPLETE,LocalDate.now());
        taskService.save(t1);
        taskService.save(t2);
        taskService.save(t3);
        taskService.save(t4);

        }



    }

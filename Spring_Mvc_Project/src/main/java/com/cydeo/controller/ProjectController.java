package com.cydeo.controller;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.RoleDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.enums.Status;
import com.cydeo.service.ProjectService;
import com.cydeo.service.RoleService;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/project")
public class ProjectController
    {
    private final UserService userService;
    private final ProjectService projectService;

    public ProjectController(UserService userService, ProjectService projectService)
        {
        this.userService = userService;
        this.projectService = projectService;
        }

    @GetMapping("/create")
    public String createProject(Model model)
        {
        model.addAttribute("project",new ProjectDTO());
        model.addAttribute("managers",userService.findManager());
        model.addAttribute("projects",projectService.findAll());
        return "/project/create";
        }

    @PostMapping("/create")
    public String insertProject(@ModelAttribute("project") ProjectDTO project)
        {
        projectService.save(project);
        return "redirect:/project/create";
        }

    @GetMapping("/delete{projectCode}")
    public String deleteProject(@PathVariable("projectCode") String projectCode)
        {
        projectService.delete(projectCode);
        return "redirect:/project/create";
        }


    @GetMapping("/update{projectCode}")
    public String editProject(@PathVariable("projectCode") String projectCode,Model model)
        {
        model.addAttribute("project",projectService.find(projectCode));
        model.addAttribute("managers",userService.findManager());
        model.addAttribute("projects",projectService.findAll());
        return "/project/update";
        }

    @PostMapping("/update")
    public String updateProject(@ModelAttribute("project") ProjectDTO project)
        {
        projectService.update(project);
        return "redirect:/project/create";
        }

    @GetMapping("/complete{projectCode}")
    public String completeProject(@PathVariable("projectCode") String projectCode)
        {
        projectService.complete(projectService.find(projectCode));
        return "redirect:/project/create";
        }

    @GetMapping("/manager/projec-status")
    public String updateStatus(Model model)
        {
         UserDTO manager=userService.find("Its CJ");
         List<ProjectDTO> projects=projectService.CountedListOfProjectDTO(manager);
         model.addAttribute("projects",projects);
        return "manager/project-status";
        }


    }

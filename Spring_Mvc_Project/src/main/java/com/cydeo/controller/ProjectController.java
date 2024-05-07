package com.cydeo.controller;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.RoleDTO;
import com.cydeo.enums.Status;
import com.cydeo.service.ProjectService;
import com.cydeo.service.RoleService;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        model.addAttribute("managers",userService.findAll());
        model.addAttribute("projects",projectService.findAll());
        return "project/create";
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


    @GetMapping("/update{project}")
    public String editProject(@ModelAttribute("project") ProjectDTO project,Model model)
        {
        model.addAttribute("project",projectService.find(project.getProjectCode()));
        projectService.update(project);
        return "redirect:/project/create";
        }

    @PostMapping("/update")
    public String updateProject(@ModelAttribute("project") ProjectDTO project)
        {

        return "redirect:/project/create";
        }

    }

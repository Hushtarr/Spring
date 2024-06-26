package com.cydeo.controller;

import com.cydeo.dto.TaskDTO;
import com.cydeo.service.ProjectService;
import com.cydeo.service.TaskService;
import com.cydeo.service.UserService;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/task")


public class TaskController
    {
    private final ProjectService projectService;
    private final TaskService taskService;
    private final UserService userService;

    public TaskController(ProjectService projectService, TaskService taskService, UserService userService)
        {
        this.projectService = projectService;
        this.taskService = taskService;
        this.userService = userService;
        }

    @GetMapping("/create")
    public String createTask(Model model)
        {
        model.addAttribute("task", new TaskDTO());
        model.addAttribute("projects", projectService.findAll());
        model.addAttribute("employees", userService.findEmployee());
        model.addAttribute("tasks", taskService.findAll());
        return "task/create";
        }

    @PostMapping("/create")
    public String createTask(@ModelAttribute("task") TaskDTO task)
        {
        taskService.save(task);
        return "redirect:/task/create";
        }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable("id") Long id)
        {
        taskService.delete(id);
        return "redirect:/task/create";
        }

    @GetMapping("/update/{id}")
    public String updateTask(@PathVariable("id") Long id, Model model)
        {
        model.addAttribute("task", taskService.find(id));
        model.addAttribute("projects", projectService.findAll());
        model.addAttribute("employees", userService.findEmployee());
        model.addAttribute("tasks", taskService.findAll());
        return "task/update";
        }

    @PostMapping("/update/{id}")
    public String updateTask(@PathVariable("id") Long id,TaskDTO task)
        {
        task.setId(id);
        taskService.update(task);
        return "redirect:/task/create";
        }
    }

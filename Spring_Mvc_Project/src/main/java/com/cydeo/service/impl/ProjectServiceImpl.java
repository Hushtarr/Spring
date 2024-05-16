package com.cydeo.service.impl;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.TaskDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.enums.Status;
import com.cydeo.service.ProjectService;
import com.cydeo.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl extends AbstractMapClass<ProjectDTO, String> implements ProjectService
    {
    TaskService taskService;

    public ProjectServiceImpl(TaskService taskService)
        {
        this.taskService = taskService;
        }

    @Override
    public ProjectDTO save(ProjectDTO project)
        {
        if (project.getStatus()==null)
        {
        project.setStatus(Status.OPEN);
        }

        return super.save(project.getProjectCode(),project);
        }

    @Override
    public void update(ProjectDTO project)
        {
        if (project.getStatus()==null)
            {
            project.setStatus(find(project.getProjectCode()).getStatus());
            }
        super.update(project.getProjectCode(),project);
        // save(project);
        }

    @Override
    public ProjectDTO find(String projectCode)
        {
        return super.find(projectCode);
        }

    @Override
    public List<ProjectDTO> findAll()
        {
        return super.findAll();
        }

    @Override
    public void delete(String projectCode)
        {
        super.delete(projectCode);
        }

    @Override
    public void complete(ProjectDTO project)
        {
        project.setStatus(Status.COMPLETE);
        }

    public List<ProjectDTO> CountedListOfProjectDTO(UserDTO manager)
        {
        List<ProjectDTO> projectList = findAll()
                .stream()
                .filter(projectDTO -> projectDTO.getAssignedManager().equals(manager))
                .map(projectDTO ->
                    {
                    List<TaskDTO>taskDTOS=taskService.findTaskByManager(manager);
                    int completedTasksCounts= (int) taskDTOS.stream().filter(x->x.getProject().equals(projectDTO)&&x.getProject().getStatus()==Status.COMPLETE).count();
                    int unfinishedTasksCounts= (int) taskDTOS.stream().filter(x->x.getProject().equals(projectDTO)&&x.getProject().getStatus()==Status.IN_PROGRESS).count();
                    projectDTO.setCompletedTasksCounts(completedTasksCounts);
                    projectDTO.setUnfinishedTasksCounts(unfinishedTasksCounts);
                    return projectDTO;
                    })
                .collect(Collectors.toList());
         return projectList;
        }
    }



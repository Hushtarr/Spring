package com.cydeo.service.impl;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProjectServiceImpl extends AbstractMapClass<ProjectDTO, String> implements ProjectService
    {

    @Override
    public ProjectDTO save(ProjectDTO object)
        {
        return super.save(object.getProjectCode(),object);
        }

    @Override
    public void update(ProjectDTO project)
        {
        super.update(project.getProjectCode(),project);
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
    }

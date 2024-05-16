package com.cydeo.converter;

import com.cydeo.dto.TaskDTO;
import com.cydeo.service.ProjectService;
import com.cydeo.service.TaskService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TaskConverter implements Converter<String, TaskDTO>
    {
    TaskService taskService;

    public TaskConverter(TaskService taskService)
        {
        this.taskService = taskService;
        }

    @Override
    public TaskDTO convert(String source)
        {
        return taskService.find(Long.parseLong(source));
        }
    }

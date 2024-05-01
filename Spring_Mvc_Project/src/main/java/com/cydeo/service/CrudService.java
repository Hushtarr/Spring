package com.cydeo.service;

import com.cydeo.dto.RoleDTO;
import com.cydeo.dto.UserDTO;

import java.util.List;

public interface CrudService<Type,Reference>
    {
    Type save(Type user);
    Type find(Reference id);
    List<Type> findAll();
    void delete(Reference id);
    }

package com.cydeo.service;

import com.cydeo.dto.RoleDTO;
import com.cydeo.dto.UserDTO;

import java.util.List;

public interface CrudService<Type,Reference>
    {
    Type save(Type object);
    Type find(Reference reference);
    List<Type> findAll();
    void delete(Reference reference);
    void update(Type object);
    }

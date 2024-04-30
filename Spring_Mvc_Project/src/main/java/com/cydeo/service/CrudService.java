package com.cydeo.service;

import com.cydeo.dto.RoleDTO;
import com.cydeo.dto.UserDTO;

import java.util.List;

public interface CrudService<T,ID>
    {
    T save(T user);
    T find(ID id);
    List<T> findAll();
    void delete(ID id);
    }

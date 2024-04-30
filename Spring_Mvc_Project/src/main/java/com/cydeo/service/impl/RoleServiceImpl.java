package com.cydeo.service.impl;

import com.cydeo.dto.RoleDTO;
import com.cydeo.service.RoleService;

import java.util.List;

public class RoleServiceImpl extends AbstractMapClass<RoleDTO,Long> implements RoleService
    {

    @Override
    public RoleDTO save(RoleDTO role)
        {
        return super.save(role.getId(),role);
        }

    @Override
    public RoleDTO find(Long id)
        {
        return super.find(id);
        }

    @Override
    public List<RoleDTO> findAll()
        {
        return super.findAll();
        }

    @Override
    public void delete(Long id)
        {
        super.delete(id);
        }


    }

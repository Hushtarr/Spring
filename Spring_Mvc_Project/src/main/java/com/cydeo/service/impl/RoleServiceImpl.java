package com.cydeo.service.impl;

import com.cydeo.dto.RoleDTO;
import com.cydeo.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
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

    @Override
    public void update(RoleDTO user)
        {
        super.update(user.getId(),user);
        }


    }

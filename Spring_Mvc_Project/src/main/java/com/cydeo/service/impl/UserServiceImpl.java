package com.cydeo.service.impl;

import com.cydeo.dto.UserDTO;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl extends AbstractMapClass<UserDTO, String> implements UserService
    {
    @Override
    public UserDTO save(UserDTO user)
        {
        return super.save(user.getUserName(), user);
        }

    @Override
    public UserDTO find(String username)
        {
        return super.find(username);
        }

    @Override
    public List<UserDTO> findAll()
        {
        return super.findAll();
        }

    @Override
    public void delete(String username)
        {
        super.delete(username);
        }

    @Override
    public void update(UserDTO user)
        {
        super.update(user.getUserName(),user);
        }
    }

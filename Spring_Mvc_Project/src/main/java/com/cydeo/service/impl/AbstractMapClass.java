package com.cydeo.service.impl;

import com.cydeo.dto.ProjectDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractMapClass <Type,Reference>
    {
    public Map<Reference,Type> map=new HashMap<>();//DB
    // map<key,value>

    Type save(Reference reference,Type object)
        {
        map.put(reference,object);
        return object;
        }

    Type find(Reference reference)
        {
        return map.get(reference);
        }

    List<Type> findAll()
        {
        return new ArrayList<>(map.values());
        }

    void delete (Reference reference)
        {
        map.remove(reference);
        }

    void update(Reference reference, Type object)
        {
        map.put(reference,object);
        }

    }

package com.cydeo.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractMapClass <T,ID>
    {
    public Map<ID,T> map=new HashMap<>();//DB
    // map<key,value>

    T save(ID id,T object)
        {
        map.put(id,object);
        return object;
        }

    T find(ID id)
        {
        return map.get(id);
        }

    List<T> findAll()
        {
        return new ArrayList<>(map.values());
        }

    void delete (ID id)
        {
        map.remove(id);
        }

    }

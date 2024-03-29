package org.spring.spring_thymeleaf;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DTgenerate
    {
    public static List<Person> base()
        {
        List<Person>persons=new ArrayList<>(Arrays.asList(
                new Person(new Faker().name().fullName(),new Faker().address().country()),
                new Person(new Faker().name().fullName(),new Faker().address().country()),
                new Person(new Faker().name().fullName(),new Faker().address().country()),
                new Person(new Faker().name().fullName(),new Faker().address().country()),
                new Person(new Faker().name().fullName(),new Faker().address().country())
        ));
        return persons;
        }
    }

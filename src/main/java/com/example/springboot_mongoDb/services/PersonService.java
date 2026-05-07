package com.example.springboot_mongoDb.services;

import com.example.springboot_mongoDb.collection.Person;

import java.util.List;

public interface PersonService {
    Person addPerson(Person person);

    List<Person> getPersonByName(String personName);

    List<Person> findAll();
}

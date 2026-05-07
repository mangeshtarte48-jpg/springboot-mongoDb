package com.example.springboot_mongoDb.services;

import com.example.springboot_mongoDb.Respositray.personRepositary;
import com.example.springboot_mongoDb.collection.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceimpl implements PersonService{

    @Autowired
    private personRepositary personRepositary;

    @Override
    public Person addPerson(Person person) {
        return personRepositary.save(person);
    }

    @Override
    public List<Person> getPersonByName(String personName) {
        return personRepositary.findAllByPersonName(personName);
    }

    @Override
    public List<Person> findAll() {
        return personRepositary.findAll();
    }
}

package com.example.springboot_mongoDb.Respositray;

import com.example.springboot_mongoDb.collection.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface personRepositary extends MongoRepository<Person,String> {
    List<Person> findAllByPersonName(String personName);
}

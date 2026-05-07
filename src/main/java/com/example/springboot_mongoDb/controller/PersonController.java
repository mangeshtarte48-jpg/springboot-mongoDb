package com.example.springboot_mongoDb.controller;

import com.example.springboot_mongoDb.collection.Person;
import com.example.springboot_mongoDb.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    public ResponseEntity<Person> addPerson(@RequestBody Person person){

      Person insetPerson= personService.addPerson(person);

      return  new ResponseEntity<>(insetPerson, HttpStatus.CREATED);
    }

    @GetMapping("/{search}")
    public ResponseEntity<List<Person>> getPersonByName(@RequestParam String personName){
     // mangesh
    List<Person> getPerson= personService.getPersonByName(personName);
    return new ResponseEntity<>(getPerson,HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Person>> findAll(){

        List<Person> getAllPerson= personService.findAll();
        return new ResponseEntity<>(getAllPerson,HttpStatus.OK);
    }


}

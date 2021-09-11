package com.sofkau.crudPerson.controllers;

import com.sofkau.crudPerson.entities.Person;
import com.sofkau.crudPerson.services.PersonServicesInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api")
public class PersonController {

    @Autowired
    private PersonServicesInterface service;

    @GetMapping(value = "listPersons")
    public Iterable<Person>listPersons(){
        return service.listAllPersons();
    }

    @PostMapping(value = "savePerson")
    public Person savePerson(@RequestBody Person person){
        return service.savePerson(person);
    }

    @GetMapping("listPersonById/{id}")
    public Optional<Person> listPersonById(@PathVariable("id") int id){
        return service.listPersonById(id);
    }

    @DeleteMapping("deletePerson/{id}")
    public void deletePerson(@PathVariable("id") int id){
        service.deletePerson(id);
    }

}

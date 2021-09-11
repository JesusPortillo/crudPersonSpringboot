package com.sofkau.crudPerson.controllers;

import com.sofkau.crudPerson.entities.Person;
import com.sofkau.crudPerson.services.PersonServicesInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class PersonController {

    @Autowired
    private PersonServicesInterface service;

    @GetMapping(value = "listPersons")
    public Iterable<Person>listPersons(){
        return service.listAllPersons();
    }


}

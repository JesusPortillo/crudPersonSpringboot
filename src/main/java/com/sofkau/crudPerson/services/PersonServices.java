package com.sofkau.crudPerson.services;

import com.sofkau.crudPerson.entities.Person;
import com.sofkau.crudPerson.repositories.PersonInterfaceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class PersonServices implements PersonServicesInterface{

    @Autowired
    private PersonInterfaceRepository data;

    @Override
    public ArrayList<Person> listAllPersons() {
        return (ArrayList<Person>) data.findAll();
    }

    @Override
    public Person listPersonById(int id) {
        return null;
    }

    @Override
    public Person savePerson(Person person) {
        return data.save(person);
    }

    @Override
    public void deletePerson(int id) {

    }

    @Override
    public Person updatePerson(Person person) {
        return null;
    }
}

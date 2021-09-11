package com.sofkau.crudPerson.services;

import com.sofkau.crudPerson.entities.Person;
import com.sofkau.crudPerson.repositories.PersonInterfaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class PersonServices implements PersonServicesInterface{

    @Autowired
    private PersonInterfaceRepository data;

    @Override
    public ArrayList<Person> listAllPersons() {
        return (ArrayList<Person>) data.findAll();
    }

    @Override
    public Optional<Person> listPersonById(int id) {
            return data.findById(id);
    }

    @Override
    public Person savePerson(Person person) {
        return data.save(person);
    }

    @Override
    public void deletePerson(int id) {
        data.deleteById(id);
    }

    @Override
    public Person updatePerson(Person person) {
        return null;
    }
}

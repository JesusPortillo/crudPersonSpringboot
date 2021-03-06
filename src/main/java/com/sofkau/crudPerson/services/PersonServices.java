package com.sofkau.crudPerson.services;

import com.sofkau.crudPerson.config.exceptions.BadRequestException;
import com.sofkau.crudPerson.config.exceptions.NotFoundException;
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
        if (data.findById(id).isEmpty()){
            throw new NotFoundException("the user that you want to delete was not found");
        }
        return data.findById(id);
    }

    @Override
    public Person savePerson(Person person) {
        if (person.getName() == null || person.getName().isEmpty()){
            throw new BadRequestException("Invalid name");
        }
        if (person.getAge() == null || person.getAge().isEmpty()){
            throw new BadRequestException("Invalid age");
        }
        return data.save(person);
    }

    @Override
    public void deletePerson(int id) {
        Optional res = data.findById(id);
        if (res.isEmpty()){
            throw new NotFoundException("the user that you want to delete was not found");
        }
        data.deleteById(id);
    }

    @Override
    public Person updatePerson(Person person) {
        Optional res = data.findById(person.getId());
        if (res.isEmpty()){
            throw new BadRequestException("the user that you want to Update was not found ");
        }else {
            if (person.getName() == null || person.getName().isEmpty()){
                throw new BadRequestException("Invalid name");
            }
            if (person.getAge() == null || person.getAge().isEmpty()){
                throw new BadRequestException("Invalid age");
            }
        }
        return data.save(person);
    }
}

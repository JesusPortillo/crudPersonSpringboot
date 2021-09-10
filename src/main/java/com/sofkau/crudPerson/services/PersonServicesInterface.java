package com.sofkau.crudPerson.services;

import com.sofkau.crudPerson.entities.Person;

import java.util.ArrayList;

public interface PersonServicesInterface {

    public ArrayList<Person>listAllPersons();
    public Person listPersonById(int id);
    public Person savePerson(Person person);
    public void deletePerson(int id);
    public Person updatePerson(Person person);
}

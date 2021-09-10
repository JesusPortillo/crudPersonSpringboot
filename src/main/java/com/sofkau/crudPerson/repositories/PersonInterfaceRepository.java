package com.sofkau.crudPerson.repositories;

import com.sofkau.crudPerson.entities.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonInterfaceRepository extends CrudRepository<Person, Integer> {
}

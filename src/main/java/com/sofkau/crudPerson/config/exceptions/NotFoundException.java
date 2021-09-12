package com.sofkau.crudPerson.config.exceptions;

public class NotFoundException extends RuntimeException{

    public NotFoundException(){}

    public NotFoundException(String message){
        super(message);
    }
}

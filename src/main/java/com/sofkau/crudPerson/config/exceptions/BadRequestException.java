package com.sofkau.crudPerson.config.exceptions;

public class BadRequestException extends RuntimeException{

    public BadRequestException(){}

    public BadRequestException(String message){
        super(message);
    }
}

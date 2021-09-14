package com.sofkau.crudPerson.config;

import com.sofkau.crudPerson.config.exceptions.BadRequestException;
import com.sofkau.crudPerson.config.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;

@ControllerAdvice(annotations = RestController.class)
public class ExceptionConfig {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFoundException(Exception e){
         ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
         return giveResponse(HttpStatus.NOT_FOUND, e);
    }



    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> badRequestException(Exception e){
         ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
         return giveResponse(HttpStatus.BAD_REQUEST, e);
    }



    private ResponseEntity<HashMap> giveResponse(HttpStatus httpStatus, Exception exc) {
        HashMap<String, String> res = new HashMap<>();
        res.put("Error - ", exc.getMessage());
        res.put("Status - ", String.valueOf(httpStatus.value()));
        res.put("Time - ", String.valueOf(new Date()));

        return new ResponseEntity<>(res, httpStatus);

    }
}

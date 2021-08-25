package com.one.digitalinnovation.bird.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BirdNotFoundException extends Exception{
    public BirdNotFoundException(Long id) {
        super(String.format("Bird with id %s not found!", id));
    }
}

package com.pfe.project.Exception;

public class EntityNotFoundException extends RuntimeException{

    public EntityNotFoundException() {

    }

    public EntityNotFoundException(String message) {
        super(message);
    }
}

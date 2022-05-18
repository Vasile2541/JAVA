package com.java.employeeManager.exceptions;

public class EntityNotFoundException extends Exception {
    public EntityNotFoundException(String message, Integer id) {
        super( message + id);
    }
}

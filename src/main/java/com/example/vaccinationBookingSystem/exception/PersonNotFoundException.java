package com.example.vaccinationBookingSystem.exception;

public class PersonNotFoundException extends  RuntimeException{
    public PersonNotFoundException(String message){
        super(message);
    }
}

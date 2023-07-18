package com.example.vaccinationBookingSystem.exceptions;

public class DoctorNotFoundException extends RuntimeException {
    public DoctorNotFoundException(String message){
        super(message);
    }
}

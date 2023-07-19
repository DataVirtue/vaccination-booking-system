package com.example.vaccinationBookingSystem.exception;

public class DoctorNotFoundException extends RuntimeException {
    public DoctorNotFoundException(String message){
        super(message);
    }
}

package com.example.vaccinationBookingSystem.exception;

public class VaccinationCenterNotFoundException extends RuntimeException {
    public VaccinationCenterNotFoundException(String message) {
        super(message);
    }
}

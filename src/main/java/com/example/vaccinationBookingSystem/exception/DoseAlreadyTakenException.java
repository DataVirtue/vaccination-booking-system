package com.example.vaccinationBookingSystem.exception;

import com.example.vaccinationBookingSystem.Enum.DoseType;

public class DoseAlreadyTakenException extends  RuntimeException{
    public  DoseAlreadyTakenException(String message){
        super(message);
    }
}

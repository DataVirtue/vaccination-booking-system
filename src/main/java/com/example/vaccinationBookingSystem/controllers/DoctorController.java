package com.example.vaccinationBookingSystem.controllers;


import com.example.vaccinationBookingSystem.exceptions.DoctorNotFoundException;
import com.example.vaccinationBookingSystem.models.Doctor;
import com.example.vaccinationBookingSystem.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    DoctorService doctorService;

    @PostMapping("/add")
    public ResponseEntity addDoctor(@RequestBody Doctor doctor){
        try {
            Doctor createdDoctor = doctorService.addDoctor(doctor);
            return new ResponseEntity(createdDoctor, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity("Unable to Create Doctor", HttpStatus.BAD_REQUEST);
        }

    }
    @GetMapping("/{}")
    public ResponseEntity getDoctor(@PathVariable Integer doctorId){
        try {
            Doctor doctor = doctorService.getDoctor(doctorId);
            return new ResponseEntity(doctor, HttpStatus.CREATED);
        }
        catch (DoctorNotFoundException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            return new ResponseEntity("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}

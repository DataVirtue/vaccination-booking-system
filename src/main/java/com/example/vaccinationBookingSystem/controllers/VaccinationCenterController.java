package com.example.vaccinationBookingSystem.controllers;


import com.example.vaccinationBookingSystem.models.VaccinationCenter;
import com.example.vaccinationBookingSystem.services.VaccinationCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vaccination-center")
public class VaccinationCenterController {

    @Autowired
    VaccinationCenterService vaccinationCenterService;

    @PostMapping("/add")
    public ResponseEntity addVaccinationCenter(@RequestBody VaccinationCenter vaccinationCenter){

        try {
            VaccinationCenter createdVaccinationCenter = vaccinationCenterService.addVaccinationCenter(vaccinationCenter);
            return new ResponseEntity(createdVaccinationCenter, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity("Cannot Create Vaccination Center", HttpStatus.BAD_REQUEST);
        }
    }
}

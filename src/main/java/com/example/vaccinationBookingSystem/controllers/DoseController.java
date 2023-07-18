package com.example.vaccinationBookingSystem.controllers;


import com.example.vaccinationBookingSystem.models.Dose;
import com.example.vaccinationBookingSystem.services.DoseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dose")
public class DoseController {


    @Autowired
    DoseService doseService;

    @PostMapping("/add")
    public ResponseEntity addDose(@RequestBody Dose dose){

        try {
            return new ResponseEntity(doseService.add(dose), HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/get-dose")
    public ResponseEntity getDose(int doseId){
        try {
            return new ResponseEntity(doseService.get(doseId), HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}

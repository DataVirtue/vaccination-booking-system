package com.example.vaccinationBookingSystem.controller;


import com.example.vaccinationBookingSystem.Enum.DoseType;
import com.example.vaccinationBookingSystem.dto.response.DoseResponseDto;
import com.example.vaccinationBookingSystem.exception.DoseAlreadyTakenException;
import com.example.vaccinationBookingSystem.exception.PersonNotFoundException;
import com.example.vaccinationBookingSystem.model.Dose;
import com.example.vaccinationBookingSystem.model.Person;
import com.example.vaccinationBookingSystem.service.DoseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dose")
public class DoseController {


    @Autowired
    DoseService doseService;

    @GetMapping("/get-dose")
    public ResponseEntity getDose(int doseId){
        try {
            return new ResponseEntity(doseService.get(doseId), HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/give-dose1")
    public ResponseEntity giveVaccine(@RequestParam("personId")int personId, @RequestParam("doseType")DoseType doseType){

        try {
            DoseResponseDto doseResponseDto = doseService.giveDose1(personId,doseType);
            return new ResponseEntity(doseResponseDto, HttpStatus.ACCEPTED);

        }catch(PersonNotFoundException e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        catch (DoseAlreadyTakenException e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            System.out.println(e);
            return new ResponseEntity("Something Went Wrong",HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}

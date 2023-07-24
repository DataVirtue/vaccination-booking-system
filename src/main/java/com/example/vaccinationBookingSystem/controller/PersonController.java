package com.example.vaccinationBookingSystem.controller;



import com.example.vaccinationBookingSystem.Enum.CenterType;
import com.example.vaccinationBookingSystem.Enum.DoseType;
import com.example.vaccinationBookingSystem.dto.request.PersonRequestDto;
import com.example.vaccinationBookingSystem.dto.response.PersonResponseDto;
import com.example.vaccinationBookingSystem.exception.PersonNotFoundException;
import com.example.vaccinationBookingSystem.model.Person;
import com.example.vaccinationBookingSystem.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonService personService;

    @PostMapping("/add")
    public ResponseEntity addPerson(@RequestBody PersonRequestDto personRequestDto){

        try {
            PersonResponseDto personResponseDto = personService.addPerson(personRequestDto);

            return new ResponseEntity(personResponseDto, HttpStatus.CREATED);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }
    @PutMapping("/update-email")
    public ResponseEntity updateEmail(@RequestParam String oldEmail,@RequestParam String newEmail){

        try {
            PersonResponseDto personResponseDto = personService.updateEmail(oldEmail,newEmail);
            return new ResponseEntity(personResponseDto,HttpStatus.CREATED);
        }catch (PersonNotFoundException e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get-all-males-greater-than-age")
    public ResponseEntity getAllMalesGreaterThan(@RequestParam int age){

        try {
            List<PersonResponseDto> responseDtos = personService.getAllMalesGreaterThan(age);
            return new ResponseEntity(responseDtos,HttpStatus.FOUND);

        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get-all-females-with-one-dose-taken")
    public ResponseEntity getAllFemalesWithOneDoseTaken(){

        try {
            List<PersonResponseDto> responseDtos = personService.getAllFemalesWithOneDoseTaken();
            return new ResponseEntity(responseDtos,HttpStatus.FOUND);

        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get-fully-vaccinated-people")
    public ResponseEntity getFullyVaccinatedPeople(){

        try {
            List<PersonResponseDto> responseDtos = personService.getFullyVaccinatedPeople();
            return new ResponseEntity(responseDtos,HttpStatus.FOUND);

        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get-people-with-no-dose-taken")
    public ResponseEntity getPeopleWithNoDoseTaken(){

        try {
            List<PersonResponseDto> responseDtos = personService.getPeopleWithNoDoseTaken();
            return new ResponseEntity(responseDtos,HttpStatus.FOUND);

        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get-females-with-one-dose-taken-and-age-greater-than")
    public ResponseEntity getAllFemalesWithOneDoseTakenAndAgeGreaterThan(@RequestParam int age){

        try {
            List<PersonResponseDto> responseDtos = personService.getAllFemalesWithOneDoseTakenAndAgeGreaterThan(age);
            return new ResponseEntity(responseDtos,HttpStatus.FOUND);

        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get-males-with-both-dose-taken-and-age-greater-than")
    public ResponseEntity getMalesWithBothDoseTakenAndAgeGreaterThan(@RequestParam int age){

        try {
            List<PersonResponseDto> responseDtos = personService.getMalesWithBothDoseTakenAndAgeGreaterThan(age);
            return new ResponseEntity(responseDtos,HttpStatus.FOUND);

        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}

package com.example.vaccinationBookingSystem.controller;



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
            return new ResponseEntity(e.getMessage(),HttpStatus.CREATED);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}

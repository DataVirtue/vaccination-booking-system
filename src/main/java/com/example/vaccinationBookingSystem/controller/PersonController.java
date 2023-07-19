package com.example.vaccinationBookingSystem.controller;



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
    public ResponseEntity addPerson(@RequestBody Person person){
        System.out.println("api hit");
        try {
            Person person1 = personService.addPerson(person);

            return new ResponseEntity(person1, HttpStatus.CREATED);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }
    @PostMapping("/give-dose1")
    public ResponseEntity giveVaccine(@RequestParam("personId")int personId,@RequestParam("doseId")int doseId){

        try {
            Person person1 = personService.giveDose1(personId,doseId);
            return new ResponseEntity(person1, HttpStatus.ACCEPTED);

        }catch (Exception e){
//            System.out.println(e);
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }


}

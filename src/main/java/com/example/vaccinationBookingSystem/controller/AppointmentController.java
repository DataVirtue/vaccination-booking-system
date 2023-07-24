package com.example.vaccinationBookingSystem.controller;


import com.example.vaccinationBookingSystem.dto.response.AppointmentResponseDto;
import com.example.vaccinationBookingSystem.exception.DoctorNotFoundException;
import com.example.vaccinationBookingSystem.exception.PersonNotFoundException;
import com.example.vaccinationBookingSystem.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {


    @Autowired
    AppointmentService appointmentService;



    @PutMapping("/book-appointment")
    public ResponseEntity bookAppointment(@RequestParam int personId, @RequestParam int doctorId){

        try{
            AppointmentResponseDto appointmentResponseDto = appointmentService.bookAppointment(personId,doctorId);
            return new ResponseEntity(appointmentResponseDto, HttpStatus.CREATED);

        }catch (PersonNotFoundException e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        catch (DoctorNotFoundException e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>("Something went wrong",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get-all-appointments-for-person/{personId}")
    public ResponseEntity getAllAppointmentsForPerson(@PathVariable int personId){
        try{
            List<AppointmentResponseDto> response = appointmentService.getAllAppointmentsForPerson(personId);
            return new ResponseEntity(response,HttpStatus.ACCEPTED);
        }catch (PersonNotFoundException e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity("Something went wrong",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get-all-appointments-for-doctor/{doctorId}")
    public ResponseEntity getAllAppointmentsForDoctor(@PathVariable int doctorId){
        try{
            List<AppointmentResponseDto> response = appointmentService.getAllAppointmentsForDoctor(doctorId);
            return new ResponseEntity(response,HttpStatus.ACCEPTED);
        }catch (DoctorNotFoundException e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity("Something went wrong",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

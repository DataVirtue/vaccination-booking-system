package com.example.vaccinationBookingSystem.controller;


import com.example.vaccinationBookingSystem.dto.response.AppointmentResponseDto;
import com.example.vaccinationBookingSystem.exception.DoctorNotFoundException;
import com.example.vaccinationBookingSystem.exception.PersonNotFoundException;
import com.example.vaccinationBookingSystem.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}

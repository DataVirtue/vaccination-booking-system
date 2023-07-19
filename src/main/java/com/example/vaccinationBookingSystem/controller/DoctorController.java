package com.example.vaccinationBookingSystem.controller;


import com.example.vaccinationBookingSystem.dto.request.DoctorRequestDto;
import com.example.vaccinationBookingSystem.dto.response.DoctorResponseDto;
import com.example.vaccinationBookingSystem.exception.DoctorNotFoundException;
import com.example.vaccinationBookingSystem.exception.VaccinationCenterNotFoundException;
import com.example.vaccinationBookingSystem.model.Doctor;
import com.example.vaccinationBookingSystem.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    DoctorService doctorService;

    @PostMapping("/add")
    public ResponseEntity addDoctor(@RequestBody DoctorRequestDto doctor){
        try {
            DoctorResponseDto createdDoctor = doctorService.addDoctor(doctor);
            return new ResponseEntity(createdDoctor, HttpStatus.CREATED);
        }
        catch (VaccinationCenterNotFoundException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            System.out.println(e);
            return new ResponseEntity("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @GetMapping("/{doctorId}")
    public ResponseEntity getDoctor(@PathVariable Integer doctorId){
        try {
            DoctorResponseDto doctorResponseDto = doctorService.getDoctor(doctorId);
            return new ResponseEntity(doctorResponseDto, HttpStatus.CREATED);
        }
        catch (DoctorNotFoundException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            System.out.println(e);
            return new ResponseEntity("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
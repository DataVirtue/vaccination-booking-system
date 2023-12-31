package com.example.vaccinationBookingSystem.controller;


import com.example.vaccinationBookingSystem.dto.request.DoctorRequestDto;
import com.example.vaccinationBookingSystem.dto.response.DoctorResponseDto;
import com.example.vaccinationBookingSystem.exception.DoctorNotFoundException;
import com.example.vaccinationBookingSystem.exception.VaccinationCenterNotFoundException;
import com.example.vaccinationBookingSystem.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    DoctorService doctorService;

    @PostMapping("/add")
    public ResponseEntity addDoctor(@RequestBody DoctorRequestDto doctor) {
        try {
            DoctorResponseDto createdDoctor = doctorService.addDoctor(doctor);
            return new ResponseEntity(createdDoctor, HttpStatus.CREATED);
        } catch (VaccinationCenterNotFoundException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/{doctorId}")
    public ResponseEntity getDoctor(@PathVariable Integer doctorId) {
        try {
            DoctorResponseDto doctorResponseDto = doctorService.getDoctor(doctorId);
            return new ResponseEntity(doctorResponseDto, HttpStatus.CREATED);
        } catch (DoctorNotFoundException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get-by-age-greater-than")
    public ResponseEntity getByAgeGreaterThan(@RequestParam int age) {

        List<DoctorResponseDto> respone = new ArrayList<>();

        try {
            respone = doctorService.getByAgeGreaterThan(age);
            return new ResponseEntity(respone, HttpStatus.FOUND);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity("Something Went Wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/get-doctor-with-highest-no-of-appointments")
    public ResponseEntity getDoctorWithHighestNoOfAppointments() {

        try {
            DoctorResponseDto doctorResponseDto = doctorService.getDoctorWithHighestNoOfAppointments();
            return new ResponseEntity(doctorResponseDto, HttpStatus.FOUND);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity("Something Went Wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/get-doctor-by-vaccination-center/{centerId}")
    public ResponseEntity getDoctorByVaccinationCenter(@PathVariable int centerId) {

        try {
            List<DoctorResponseDto> responseDtos = doctorService.getDoctorByVaccinationCenter(centerId);
            return new ResponseEntity(responseDtos, HttpStatus.FOUND);

        }
        catch (VaccinationCenterNotFoundException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity("Something Went Wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/update/{doctorId}")
    public ResponseEntity updateDoctor(@PathVariable int doctorId, @RequestParam String attribute, @RequestParam String value) {
        try {
            DoctorResponseDto updatedDoctor = doctorService.updateDoctor(doctorId, attribute, value);
            return new ResponseEntity(updatedDoctor, HttpStatus.CREATED);

        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


}

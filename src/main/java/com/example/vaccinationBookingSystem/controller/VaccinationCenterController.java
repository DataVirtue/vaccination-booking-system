package com.example.vaccinationBookingSystem.controller;


import com.example.vaccinationBookingSystem.Enum.CenterType;
import com.example.vaccinationBookingSystem.dto.request.VaccinationCenterRequestDto;
import com.example.vaccinationBookingSystem.dto.response.DoctorResponseDto;
import com.example.vaccinationBookingSystem.dto.response.PersonResponseDto;
import com.example.vaccinationBookingSystem.dto.response.VaccinationCenterResponseDto;
import com.example.vaccinationBookingSystem.model.Doctor;
import com.example.vaccinationBookingSystem.model.VaccinationCenter;
import com.example.vaccinationBookingSystem.service.VaccinationCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vaccination-center")
public class VaccinationCenterController {

    @Autowired
    VaccinationCenterService vaccinationCenterService;

    @PostMapping("/add")
    public ResponseEntity addVaccinationCenter(@RequestBody VaccinationCenterRequestDto vaccinationCenterRequestDto){

        try {
            VaccinationCenterResponseDto vaccinationCenterResponseDto = vaccinationCenterService.addVaccinationCenter(vaccinationCenterRequestDto);
            return new ResponseEntity(vaccinationCenterResponseDto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity("Cannot Create Vaccination Center", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get-all-doctor-with-center-type")
    public ResponseEntity getAllDoctorsWithCenterType(@RequestParam CenterType centerType){

        try {
            List<DoctorResponseDto> responseDtos = vaccinationCenterService.getAllDoctorsWithCenterType(centerType);
            return new ResponseEntity(responseDtos,HttpStatus.FOUND);

        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}

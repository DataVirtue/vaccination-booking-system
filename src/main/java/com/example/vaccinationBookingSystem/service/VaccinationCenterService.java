package com.example.vaccinationBookingSystem.service;

import com.example.vaccinationBookingSystem.dto.request.VaccinationCenterRequestDto;
import com.example.vaccinationBookingSystem.dto.response.VaccinationCenterResponseDto;
import com.example.vaccinationBookingSystem.model.VaccinationCenter;
import com.example.vaccinationBookingSystem.repository.VaccinationCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VaccinationCenterService {

    @Autowired
    VaccinationCenterRepository vaccinationCenterRepository;

    public VaccinationCenterResponseDto addVaccinationCenter(VaccinationCenterRequestDto vaccinationCenterRequestDto) {

        // request dto to entity
        VaccinationCenter vaccinationCenter = new VaccinationCenter();
        vaccinationCenter.setCenterName(vaccinationCenterRequestDto.getCenterName());
        vaccinationCenter.setCenterType(vaccinationCenterRequestDto.getCenterType());
        vaccinationCenter.setAddress(vaccinationCenterRequestDto.getAddress());

        //save
        VaccinationCenter savedVaccinationCenter = vaccinationCenterRepository.save(vaccinationCenter);

        // saved object to respone Dto

        VaccinationCenterResponseDto vaccinationCenterResponseDto = new VaccinationCenterResponseDto();
        vaccinationCenterResponseDto.setCenterName(savedVaccinationCenter.getCenterName());
        vaccinationCenterResponseDto.setCenterType(savedVaccinationCenter.getCenterType());
        vaccinationCenterResponseDto.setAddress(savedVaccinationCenter.getAddress());

        return vaccinationCenterResponseDto;
    }


}

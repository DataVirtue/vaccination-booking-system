package com.example.vaccinationBookingSystem.service;

import com.example.vaccinationBookingSystem.dto.request.VaccinationCenterRequestDto;
import com.example.vaccinationBookingSystem.dto.response.VaccinationCenterResponseDto;
import com.example.vaccinationBookingSystem.model.VaccinationCenter;
import com.example.vaccinationBookingSystem.repository.VaccinationCenterRepository;
import com.example.vaccinationBookingSystem.transformer.VaccinationCenterTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VaccinationCenterService {

    @Autowired
    VaccinationCenterRepository vaccinationCenterRepository;

    public VaccinationCenterResponseDto addVaccinationCenter(VaccinationCenterRequestDto vaccinationCenterRequestDto) {

        // request dto to entity
        VaccinationCenter vaccinationCenter = VaccinationCenterTransformer.vaccinationCenterRequestDtoToVaccinationCenter(vaccinationCenterRequestDto);

        //save
        VaccinationCenter savedVaccinationCenter = vaccinationCenterRepository.save(vaccinationCenter);

        // saved object to respone Dto

        VaccinationCenterResponseDto vaccinationCenterResponseDto = VaccinationCenterTransformer.vaccinationCenterToVaccinationCenterResponseDto(savedVaccinationCenter);

        return vaccinationCenterResponseDto;
    }


}

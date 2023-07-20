package com.example.vaccinationBookingSystem.transformer;

import com.example.vaccinationBookingSystem.dto.request.VaccinationCenterRequestDto;
import com.example.vaccinationBookingSystem.dto.response.VaccinationCenterResponseDto;
import com.example.vaccinationBookingSystem.model.VaccinationCenter;

public class VaccinationCenterTransformer {

    public static VaccinationCenterResponseDto vaccinationCenterToVaccinationCenterResponseDto(VaccinationCenter vaccinationCenter){

        return  VaccinationCenterResponseDto.builder()
                .centerName(vaccinationCenter.getCenterName())
                .address(vaccinationCenter.getAddress())
                .centerType(vaccinationCenter.getCenterType())
                .build();

    }

    public static VaccinationCenter vaccinationCenterRequestDtoToVaccinationCenter(VaccinationCenterRequestDto vaccinationCenterRequestDto){

        return VaccinationCenter.builder()
                .centerName(vaccinationCenterRequestDto.getCenterName())
                .centerType(vaccinationCenterRequestDto.getCenterType())
                .address(vaccinationCenterRequestDto.getAddress())
                .build();
    }

}

package com.example.vaccinationBookingSystem.transformer;

import com.example.vaccinationBookingSystem.dto.response.DoseResponseDto;
import com.example.vaccinationBookingSystem.model.Dose;

public class DoseTransformer {

    public static DoseResponseDto doseResponseDtoToDose(Dose dose){

        return DoseResponseDto.builder()
                .doseId(dose.getDoseId())
                .doseType(dose.getDoseType())
                .vaccinationDate(dose.getVaccinationDate())
                .personName(dose.getPerson().getName())
                .build();
    }
}

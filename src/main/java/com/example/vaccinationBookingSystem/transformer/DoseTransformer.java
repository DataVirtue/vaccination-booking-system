package com.example.vaccinationBookingSystem.transformer;

import com.example.vaccinationBookingSystem.Enum.DoseType;
import com.example.vaccinationBookingSystem.dto.response.DoseResponseDto;
import com.example.vaccinationBookingSystem.model.Dose;

import java.util.UUID;

public class DoseTransformer {


    public static Dose doseRequestToDose(DoseType doseType){

        return Dose.builder().doseId(UUID.randomUUID().toString())
                .doseType(doseType)
                .build();

    }

    public static DoseResponseDto doseToDoseResponeDto(Dose dose){

        return DoseResponseDto.builder()
                .doseId(dose.getDoseId())
                .doseType(dose.getDoseType())
                .vaccinationDate(dose.getVaccinationDate())
                .personName(dose.getPerson().getName())
                .build();
    }
}

package com.example.vaccinationBookingSystem.transformer;

import com.example.vaccinationBookingSystem.dto.request.DoctorRequestDto;
import com.example.vaccinationBookingSystem.dto.response.DoctorResponseDto;
import com.example.vaccinationBookingSystem.model.Doctor;

public class DoctorTransformer {

    public static Doctor doctorRequestDtoToDoctor(DoctorRequestDto doctorRequestDto){

        return  Doctor.builder()
                .age(doctorRequestDto.getAge())
                .name(doctorRequestDto.getName())
                .emailId(doctorRequestDto.getEmailId())
                .gender(doctorRequestDto.getGender())
                .build();
    }

    public static DoctorResponseDto doctorToResponseDto(Doctor doctor){

       return DoctorResponseDto.builder()
                .name(doctor.getName())
                .age(doctor.getAge())
                .emailId(doctor.getEmailId())
                .gender(doctor.getGender())
                .build();

    }

}

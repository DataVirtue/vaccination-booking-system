package com.example.vaccinationBookingSystem.service;

import com.example.vaccinationBookingSystem.Enum.CenterType;
import com.example.vaccinationBookingSystem.dto.request.VaccinationCenterRequestDto;
import com.example.vaccinationBookingSystem.dto.response.DoctorResponseDto;
import com.example.vaccinationBookingSystem.dto.response.VaccinationCenterResponseDto;
import com.example.vaccinationBookingSystem.exception.VaccinationCenterNotFoundException;
import com.example.vaccinationBookingSystem.model.Doctor;
import com.example.vaccinationBookingSystem.model.VaccinationCenter;
import com.example.vaccinationBookingSystem.repository.DoctorRepository;
import com.example.vaccinationBookingSystem.repository.VaccinationCenterRepository;
import com.example.vaccinationBookingSystem.transformer.DoctorTransformer;
import com.example.vaccinationBookingSystem.transformer.VaccinationCenterTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VaccinationCenterService {

    @Autowired
    VaccinationCenterRepository vaccinationCenterRepository;

    @Autowired
    DoctorRepository doctorRepository;

    public VaccinationCenterResponseDto addVaccinationCenter(VaccinationCenterRequestDto vaccinationCenterRequestDto) {

        // request dto to entity
        VaccinationCenter vaccinationCenter = VaccinationCenterTransformer.vaccinationCenterRequestDtoToVaccinationCenter(vaccinationCenterRequestDto);

        //save
        VaccinationCenter savedVaccinationCenter = vaccinationCenterRepository.save(vaccinationCenter);

        // saved object to respone Dto

        VaccinationCenterResponseDto vaccinationCenterResponseDto = VaccinationCenterTransformer.vaccinationCenterToVaccinationCenterResponseDto(savedVaccinationCenter);

        return vaccinationCenterResponseDto;
    }

    public List<DoctorResponseDto> getAllDoctorsWithCenterType(CenterType centerType){

        List<Doctor> doctorList = doctorRepository.getAllDoctorsWithCenterType(centerType.toString());

        List<DoctorResponseDto> responseDtos = new ArrayList<>();

        for(Doctor doctor: doctorList){

            DoctorResponseDto doctorResponseDto = DoctorTransformer.doctorToResponseDto(doctor);
            doctorResponseDto.setVaccinationCenter(VaccinationCenterTransformer.vaccinationCenterToVaccinationCenterResponseDto(doctor.getVaccinationCenter()));
            responseDtos.add(doctorResponseDto);
//            System.out.println(doctorResponseDto);
        }
        return responseDtos;
    }


}

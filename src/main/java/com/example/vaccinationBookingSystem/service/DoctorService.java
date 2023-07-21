package com.example.vaccinationBookingSystem.service;

import com.example.vaccinationBookingSystem.dto.request.DoctorRequestDto;
import com.example.vaccinationBookingSystem.dto.response.DoctorResponseDto;
import com.example.vaccinationBookingSystem.dto.response.VaccinationCenterResponseDto;
import com.example.vaccinationBookingSystem.exception.DoctorNotFoundException;
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
public class DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    VaccinationCenterRepository vaccinationCenterRepository;

    private DoctorResponseDto convertDoctorToResponseDto(Doctor doctor){
        DoctorResponseDto doctorResponseDto = DoctorTransformer.doctorToResponseDto(doctor);

        VaccinationCenterResponseDto vaccinationCenterResponseDto
                = VaccinationCenterTransformer.vaccinationCenterToVaccinationCenterResponseDto(doctor.getVaccinationCenter());

        doctorResponseDto.setVaccinationCenter(vaccinationCenterResponseDto);
        return doctorResponseDto;
    }

    public DoctorResponseDto addDoctor(DoctorRequestDto doctorRequestDto) {
        Doctor doctor = DoctorTransformer.doctorRequestDtoToDoctor(doctorRequestDto);

        Optional<VaccinationCenter> optionalVaccinationCenter = vaccinationCenterRepository.findById(doctorRequestDto.getVaccinationCenterId());

        if(optionalVaccinationCenter.isEmpty())
            throw new VaccinationCenterNotFoundException("Invalid Center Id");

        doctor.setVaccinationCenter(optionalVaccinationCenter.get());

        Doctor savedDoctor = doctorRepository.save(doctor);


        return convertDoctorToResponseDto(savedDoctor);
    }

    public DoctorResponseDto getDoctor(Integer doctorId) {

        Optional<Doctor> optionalDoctor = doctorRepository.findById(doctorId);

        if(optionalDoctor.isEmpty()){
            throw new DoctorNotFoundException("Invalid Id");
        }

        return convertDoctorToResponseDto(optionalDoctor.get());
    }

    public List<DoctorResponseDto> getByAgeGreaterThan(int age) {

        List<Doctor> doctors = doctorRepository.getByAgeGreaterThan(age);
        List<DoctorResponseDto> doctorResponseDtoList = new ArrayList<>();
        for(Doctor doctor: doctors){
            doctorResponseDtoList.add(DoctorTransformer.doctorToResponseDto(doctor));
        }
        return doctorResponseDtoList;
    }
}

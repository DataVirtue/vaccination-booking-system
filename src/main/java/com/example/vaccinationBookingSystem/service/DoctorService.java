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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    VaccinationCenterRepository vaccinationCenterRepository;

    private DoctorResponseDto convertDoctorToResponseDto(Doctor doctor, String message){
        DoctorResponseDto doctorResponseDto = new DoctorResponseDto();
        doctorResponseDto.setName(doctor.getName());
        doctorResponseDto.setMessage(message);

        VaccinationCenterResponseDto  vaccinationCenterResponseDto = new VaccinationCenterResponseDto();

        vaccinationCenterResponseDto.setCenterName(doctor.getVaccinationCenter().getCenterName());

        vaccinationCenterResponseDto.setAddress(doctor.getVaccinationCenter().getAddress());

        vaccinationCenterResponseDto.setCenterType(doctor.getVaccinationCenter().getCenterType());

        doctorResponseDto.setVaccinationCenter(vaccinationCenterResponseDto);

        return doctorResponseDto;
    }

    public DoctorResponseDto addDoctor(DoctorRequestDto doctorRequestDto) {
        Doctor doctor = new Doctor();
        doctor.setAge(doctorRequestDto.getAge());

        doctor.setName(doctorRequestDto.getName());

        doctor.setEmailId(doctorRequestDto.getEmailId());

        doctor.setGender(doctorRequestDto.getGender());

        Optional<VaccinationCenter> optionalVaccinationCenter = vaccinationCenterRepository.findById(doctorRequestDto.getVaccinationCenterId());

        if(optionalVaccinationCenter.isEmpty())
            throw new VaccinationCenterNotFoundException("Invalid Center Id");

        doctor.setVaccinationCenter(optionalVaccinationCenter.get());

        Doctor savedDoctor = doctorRepository.save(doctor);
        return convertDoctorToResponseDto(savedDoctor, "Dr. " + savedDoctor.getName() + " Added Successfully");
    }

    public DoctorResponseDto getDoctor(Integer doctorId) {

        Optional<Doctor> optionalDoctor = doctorRepository.findById(doctorId);

        if(optionalDoctor.isEmpty()){
            throw new DoctorNotFoundException("Invalid Id");
        }

        return convertDoctorToResponseDto(optionalDoctor.get(),"");
    }
}

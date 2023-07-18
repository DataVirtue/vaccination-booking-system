package com.example.vaccinationBookingSystem.services;

import com.example.vaccinationBookingSystem.exceptions.DoctorNotFoundException;
import com.example.vaccinationBookingSystem.models.Doctor;
import com.example.vaccinationBookingSystem.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    public Doctor addDoctor(Doctor doctor) {

        return doctorRepository.save(doctor);
    }

    public Doctor getDoctor(Integer doctorId) {

        Optional<Doctor> optionalDoctor = doctorRepository.findById(doctorId);

        if(optionalDoctor.isEmpty()){
            throw new DoctorNotFoundException("Invalid Id");
        }

        return optionalDoctor.get();
    }
}

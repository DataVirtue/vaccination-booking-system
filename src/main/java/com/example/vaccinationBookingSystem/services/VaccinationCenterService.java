package com.example.vaccinationBookingSystem.services;

import com.example.vaccinationBookingSystem.models.VaccinationCenter;
import com.example.vaccinationBookingSystem.repositories.VaccinationCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VaccinationCenterService {

    @Autowired
    VaccinationCenterRepository vaccinationCenterRepository;

    public VaccinationCenter addVaccinationCenter(VaccinationCenter vaccinationCenter) {

        return vaccinationCenterRepository.save(vaccinationCenter);
    }


}

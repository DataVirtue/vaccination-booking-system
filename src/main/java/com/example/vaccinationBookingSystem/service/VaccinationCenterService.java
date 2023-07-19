package com.example.vaccinationBookingSystem.service;

import com.example.vaccinationBookingSystem.model.VaccinationCenter;
import com.example.vaccinationBookingSystem.repository.VaccinationCenterRepository;
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

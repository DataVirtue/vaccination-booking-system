package com.example.vaccinationBookingSystem.services;

import com.example.vaccinationBookingSystem.models.Dose;
import com.example.vaccinationBookingSystem.repositories.DoseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class DoseService {

    @Autowired
    DoseRepository doseRepository;
    public Dose add(Dose dose) {
        dose.setDoseId(String.valueOf(UUID.randomUUID()));
        return doseRepository.save(dose);
    }

    public Dose get(int doseId) {

        Optional<Dose> optionalDose = doseRepository.findById(doseId);

        if(optionalDose.isEmpty()){
            throw new RuntimeException("Dose Not Found");

        }
        return  optionalDose.get();
    }
}

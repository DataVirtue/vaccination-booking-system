package com.example.vaccinationBookingSystem.service;

import com.example.vaccinationBookingSystem.Enum.DoseType;
import com.example.vaccinationBookingSystem.dto.response.DoseResponseDto;
import com.example.vaccinationBookingSystem.exception.DoseAlreadyTakenException;
import com.example.vaccinationBookingSystem.exception.PersonNotFoundException;
import com.example.vaccinationBookingSystem.model.Dose;
import com.example.vaccinationBookingSystem.model.Person;
import com.example.vaccinationBookingSystem.repository.DoseRepository;
import com.example.vaccinationBookingSystem.repository.PersonRepository;
import com.example.vaccinationBookingSystem.transformer.DoseTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;
import java.util.UUID;

@Service
public class DoseService {

    @Autowired
    DoseRepository doseRepository;

    @Autowired
    PersonRepository personRepository;


    public Dose get(int doseId) {

        Optional<Dose> optionalDose = doseRepository.findById(doseId);

        if (optionalDose.isEmpty()) {
            throw new RuntimeException("Dose Not Found");

        }

        return optionalDose.get();
    }

    public DoseResponseDto giveDose1(int personId, DoseType doseType) {

        Optional<Person> optionalPerson = personRepository.findById(personId);


        if (optionalPerson.isEmpty()) {
            throw new PersonNotFoundException("Invalid person Id");
        }

        Person person = optionalPerson.get();

        if (person.isDose1Taken()) {
            throw new DoseAlreadyTakenException("Dose 1 Already Taken");
        }
        person.setDose1Taken(true);

        Dose dose = new Dose();
        dose.setDoseType(doseType);
        dose.setDoseId(UUID.randomUUID().toString());
        dose.setPerson(person);

        dose.setPerson(person);

        person.getDoseList().add(dose);

        Dose savedDose = personRepository.save(person).getDoseList().get(0);

       return DoseTransformer.doseResponseDtoToDose(savedDose);

    }
}
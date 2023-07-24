package com.example.vaccinationBookingSystem.service;

import com.example.vaccinationBookingSystem.Enum.DoseType;
import com.example.vaccinationBookingSystem.dto.response.DoseResponseDto;
import com.example.vaccinationBookingSystem.exception.DoseEligibityException;
import com.example.vaccinationBookingSystem.exception.PersonNotFoundException;
import com.example.vaccinationBookingSystem.model.Dose;
import com.example.vaccinationBookingSystem.model.Person;
import com.example.vaccinationBookingSystem.repository.DoseRepository;
import com.example.vaccinationBookingSystem.repository.PersonRepository;
import com.example.vaccinationBookingSystem.transformer.DoseTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    private Person getPerson(int personId){

        Optional<Person> optionalPerson = personRepository.findById(personId);


        if (optionalPerson.isEmpty()) {
            throw new PersonNotFoundException("Invalid person Id");
        }
        return optionalPerson.get();
    }


    public DoseResponseDto giveDose1(int personId, DoseType doseType) {

        Person person = getPerson(personId);


        if (person.isDose1Taken()) {
            throw new DoseEligibityException("Dose 1 Already Taken");
        }

        person.setDose1Taken(true);

        Dose dose = DoseTransformer.doseRequestToDose(doseType);

        dose.setPerson(person);


        person.getDoseList().add(dose);

        Dose savedDose = personRepository.save(person).getDoseList().get(0);

       return DoseTransformer.doseToDoseResponeDto(savedDose);

    }

    public DoseResponseDto giveDose2(int personId, DoseType doseType) {

        Person person = getPerson(personId);

        if(!person.isDose1Taken()){
            throw new DoseEligibityException("Cannot take dose 2 before dose 1");
        }

        if(person.isDose2Taken()){
            throw new DoseEligibityException("Dose 2 Already Taken");
        }

        Dose dose = DoseTransformer.doseRequestToDose(doseType);

        dose.setPerson(person);
        person.setDose2Taken(true);

        person.getDoseList().add(dose);

        Dose savedDose = personRepository.save(person).getDoseList().get(0);

        return DoseTransformer.doseToDoseResponeDto(savedDose);



    }
}
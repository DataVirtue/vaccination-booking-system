package com.example.vaccinationBookingSystem.service;


import com.example.vaccinationBookingSystem.model.Dose;
import com.example.vaccinationBookingSystem.model.Person;
import com.example.vaccinationBookingSystem.repository.DoseRepository;
import com.example.vaccinationBookingSystem.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    DoseRepository doseRepository;

    public Person addPerson(Person person) {

        return personRepository.save(person);

    }

    public Person giveDose1(int personId, int doseId) {

        Optional<Person> optionalPerson = personRepository.findById(personId);

        Optional<Dose> optionalDose = doseRepository.findById(doseId);

        if (optionalPerson.isEmpty()) {
            throw new RuntimeException("Person Not Found");
        }


        if (optionalDose.isEmpty()) {
            throw new RuntimeException("Invalid Dose Id");
        }

        Dose dose = optionalDose.get();
        Person person = optionalPerson.get();

        if (person.isDose1Taken()) {
            throw new RuntimeException("Dose 1 Already Taken");
        }


        dose.setPerson(person);

        person.setDose1Taken(true);

        System.out.println(doseRepository.save(dose));

        return personRepository.save(person);

    }
}

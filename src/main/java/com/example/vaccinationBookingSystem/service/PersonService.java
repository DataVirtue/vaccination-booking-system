package com.example.vaccinationBookingSystem.service;


import com.example.vaccinationBookingSystem.Enum.DoseType;
import com.example.vaccinationBookingSystem.dto.request.PersonRequestDto;
import com.example.vaccinationBookingSystem.dto.response.PersonResponseDto;
import com.example.vaccinationBookingSystem.exception.DoseAlreadyTakenException;
import com.example.vaccinationBookingSystem.exception.PersonNotFoundException;
import com.example.vaccinationBookingSystem.model.Dose;
import com.example.vaccinationBookingSystem.model.Person;
import com.example.vaccinationBookingSystem.repository.DoseRepository;
import com.example.vaccinationBookingSystem.repository.PersonRepository;
import com.example.vaccinationBookingSystem.transformer.PersonTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    DoseRepository doseRepository;

    public PersonResponseDto addPerson(PersonRequestDto personRequestDto) {

        Person person = PersonTransformer.personRequestDtoToPerson(personRequestDto);

        Person savedPerson = personRepository.save(person);

        PersonResponseDto personResponseDto = PersonTransformer.personToPersonResponseDto(savedPerson);

        return personResponseDto;

    }

    public PersonResponseDto updateEmail(String oldEmail, String newEmail) {

        Person person = personRepository.findByEmailId(oldEmail);
        if(person==null)
            throw new PersonNotFoundException("Email doesn't exist");

        person.setEmailId(newEmail);
        Person savedPerson = personRepository.save(person);

        return PersonTransformer.personToPersonResponseDto(person);
    }
}

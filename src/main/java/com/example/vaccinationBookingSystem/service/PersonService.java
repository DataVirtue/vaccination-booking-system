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
        Person person  = new Person();

        person.setAadharCardNo(personRequestDto.getAadharCardNo());
        person.setGender(personRequestDto.getGender());
        person.setName(personRequestDto.getName());
        person.setEmailId(personRequestDto.getEmailId());
        person.setAge(personRequestDto.getAge());

        Person savedPerson = personRepository.save(person);

        PersonResponseDto personResponseDto = new PersonResponseDto();
        personResponseDto.setName(savedPerson.getName());
        personResponseDto.setEmailId(savedPerson.getEmailId());

        personResponseDto.setDose1Taken(savedPerson.isDose1Taken());
        personResponseDto.setDose2Taken(savedPerson.isDose2Taken());

        return personResponseDto;

    }

}

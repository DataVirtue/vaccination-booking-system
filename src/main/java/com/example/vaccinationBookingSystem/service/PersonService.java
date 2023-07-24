package com.example.vaccinationBookingSystem.service;


import com.example.vaccinationBookingSystem.dto.request.PersonRequestDto;
import com.example.vaccinationBookingSystem.dto.response.PersonResponseDto;
import com.example.vaccinationBookingSystem.exception.PersonNotFoundException;
import com.example.vaccinationBookingSystem.model.Person;
import com.example.vaccinationBookingSystem.repository.DoseRepository;
import com.example.vaccinationBookingSystem.repository.PersonRepository;
import com.example.vaccinationBookingSystem.transformer.PersonTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public List<PersonResponseDto> getAllMalesGreaterThan(int age) {

        List<PersonResponseDto> responseDtos = new ArrayList<>();
        List<Person> personList = personRepository.getAllMalesGreaterThan(age);

        for(Person person: personList){
            responseDtos.add(PersonTransformer.personToPersonResponseDto(person));
        }
        return responseDtos;
    }

    public List<PersonResponseDto> getAllFemalesWithOneDoseTaken() {

        List<PersonResponseDto> responseDtos = new ArrayList<>();
        List<Person> personList = personRepository.getAllFemalesWithOneDoseTaken();

        for(Person person: personList){
            responseDtos.add(PersonTransformer.personToPersonResponseDto(person));
        }
        return responseDtos;
    }

    public List<PersonResponseDto> getFullyVaccinatedPeople() {

        List<PersonResponseDto> responseDtos = new ArrayList<>();
        List<Person> personList = personRepository.getFullyVaccinatedPeople();

        for(Person person: personList){
            responseDtos.add(PersonTransformer.personToPersonResponseDto(person));
        }
        return responseDtos;
    }

    public List<PersonResponseDto> getPeopleWithNoDoseTaken(){


        List<PersonResponseDto> responseDtos = new ArrayList<>();
        List<Person> personList = personRepository.getPeopleWithNoDoseTaken();

        for(Person person: personList){
            responseDtos.add(PersonTransformer.personToPersonResponseDto(person));
        }
        return responseDtos;

    }

    public List<PersonResponseDto> getAllFemalesWithOneDoseTakenAndAgeGreaterThan(int age){

        List<PersonResponseDto> responseDtos = new ArrayList<>();
        List<Person> personList = personRepository.getAllFemalesWithOneDoseTakenAndAgeGreaterThan(age);

        for(Person person: personList){
            responseDtos.add(PersonTransformer.personToPersonResponseDto(person));
        }
        return responseDtos;
    }

    public List<PersonResponseDto> getMalesWithBothDoseTakenAndAgeGreaterThan(int age){

        List<PersonResponseDto> responseDtos = new ArrayList<>();
        List<Person> personList = personRepository.getMalesWithBothDoseTakenAndAgeGreaterThan(age);

        for(Person person: personList){
            responseDtos.add(PersonTransformer.personToPersonResponseDto(person));
        }
        return responseDtos;
    }

}

package com.example.vaccinationBookingSystem.transformer;

import com.example.vaccinationBookingSystem.dto.request.PersonRequestDto;
import com.example.vaccinationBookingSystem.dto.response.PersonResponseDto;
import com.example.vaccinationBookingSystem.model.Person;

public class PersonTransformer {

    public static Person personRequestDtoToPerson(PersonRequestDto personRequestDto){


       return Person.builder()
                .aadharCardNo(personRequestDto.getAadharCardNo())
                .gender(personRequestDto.getGender())
                .name(personRequestDto.getName())
                .emailId(personRequestDto.getEmailId())
                .age(personRequestDto.getAge()).build();
    }
    public static PersonResponseDto personToPersonResponseDto(Person person){

        return PersonResponseDto.builder().
                name(person.getName())
                .emailId(person.getEmailId())
                .dose1Taken(person.isDose1Taken())
                .dose2Taken(person.isDose2Taken())
                .build();
    }
}

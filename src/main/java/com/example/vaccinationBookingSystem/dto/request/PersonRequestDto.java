package com.example.vaccinationBookingSystem.dto.request;


import com.example.vaccinationBookingSystem.Enum.Gender;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PersonRequestDto {

    int aadharCardNo;

    int age;
    String name;


    String emailId;

    Gender gender;



}

package com.example.vaccinationBookingSystem.dto.response;


import com.example.vaccinationBookingSystem.Enum.Gender;
import jakarta.persistence.Column;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PersonResponseDto {


    String name;


    String emailId;

   boolean dose1Taken;

   boolean dose2Taken;



}

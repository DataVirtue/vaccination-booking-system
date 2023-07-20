package com.example.vaccinationBookingSystem.dto.response;


import com.example.vaccinationBookingSystem.Enum.Gender;
import jakarta.persistence.Column;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class PersonResponseDto {


    String name;


    String emailId;

   boolean dose1Taken;

   boolean dose2Taken;



}

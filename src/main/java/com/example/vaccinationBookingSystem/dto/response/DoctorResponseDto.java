package com.example.vaccinationBookingSystem.dto.response;


import com.example.vaccinationBookingSystem.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class DoctorResponseDto {
    String name;

    int age;

    String emailId;

    Gender gender;

    VaccinationCenterResponseDto vaccinationCenter;

}

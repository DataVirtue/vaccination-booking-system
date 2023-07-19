package com.example.vaccinationBookingSystem.dto.request;


import com.example.vaccinationBookingSystem.Enum.Gender;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class DoctorRequestDto {
    String name;

    int age;

    String emailId;

    Gender gender;

    int vaccinationCenterId;

}

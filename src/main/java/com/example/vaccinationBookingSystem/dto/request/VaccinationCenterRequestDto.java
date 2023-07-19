package com.example.vaccinationBookingSystem.dto.request;


import com.example.vaccinationBookingSystem.Enum.CenterType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class VaccinationCenterRequestDto {

    String centerName;

    CenterType centerType;

    String address;

}

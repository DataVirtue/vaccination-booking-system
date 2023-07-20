package com.example.vaccinationBookingSystem.dto.response;


import com.example.vaccinationBookingSystem.Enum.CenterType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class VaccinationCenterResponseDto {
    String centerName;
    CenterType centerType;

    String address;

}

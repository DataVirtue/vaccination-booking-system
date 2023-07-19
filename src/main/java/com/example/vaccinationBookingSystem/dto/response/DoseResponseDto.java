package com.example.vaccinationBookingSystem.dto.response;

import com.example.vaccinationBookingSystem.Enum.DoseType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DoseResponseDto {
    String doseId;
    DoseType doseType;

    Date vaccinationDate;

    String personName;

}

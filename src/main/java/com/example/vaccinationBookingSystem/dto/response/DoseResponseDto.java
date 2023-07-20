package com.example.vaccinationBookingSystem.dto.response;

import com.example.vaccinationBookingSystem.Enum.DoseType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class DoseResponseDto {
    String doseId;
    DoseType doseType;

    Date vaccinationDate;

    String personName;

}

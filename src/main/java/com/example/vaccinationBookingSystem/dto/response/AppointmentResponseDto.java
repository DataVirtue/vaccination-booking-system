package com.example.vaccinationBookingSystem.dto.response;


import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class AppointmentResponseDto {

    String appointmentId;

    String personName;

    String doctorName;

    String centerName;

    String centerAddress;

    String message;
}

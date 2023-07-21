package com.example.vaccinationBookingSystem.transformer;

import com.example.vaccinationBookingSystem.dto.response.AppointmentResponseDto;
import com.example.vaccinationBookingSystem.model.Appointment;

public class AppointmentTransformer {

    public static AppointmentResponseDto appoointmentToAppointmentResponseDto(Appointment appointment){

        return AppointmentResponseDto.builder()
                .appointmentId(appointment.getAppointmentId())
                .personName(appointment.getPerson().getName())
                .centerName(appointment.getDoctor().getVaccinationCenter().getCenterName())
                .centerAddress(appointment.getDoctor().getVaccinationCenter().getAddress())
                .doctorName(appointment.getDoctor().getName())
                .message("Appointment Booking Successful")
                .build();
    }
}

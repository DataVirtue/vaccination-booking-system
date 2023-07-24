package com.example.vaccinationBookingSystem.service;


import com.example.vaccinationBookingSystem.dto.response.AppointmentResponseDto;
import com.example.vaccinationBookingSystem.exception.DoctorNotFoundException;
import com.example.vaccinationBookingSystem.exception.PersonNotFoundException;
import com.example.vaccinationBookingSystem.model.Appointment;
import com.example.vaccinationBookingSystem.model.Doctor;
import com.example.vaccinationBookingSystem.model.Person;
import com.example.vaccinationBookingSystem.repository.AppointmentRepository;
import com.example.vaccinationBookingSystem.repository.DoctorRepository;
import com.example.vaccinationBookingSystem.repository.PersonRepository;
import com.example.vaccinationBookingSystem.transformer.AppointmentTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AppointmentService {

    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    PersonRepository personRepository;


    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    JavaMailSender javaMailSender;

    public AppointmentResponseDto bookAppointment(int personId, int doctorId) {

        Optional<Person> optionalPerson = personRepository.findById(personId);

        if(optionalPerson.isEmpty()){
            throw new PersonNotFoundException("Invalid Person Id");
        }

        Optional<Doctor> optionalDoctor = doctorRepository.findById(doctorId);

        if(optionalDoctor.isEmpty()){
            throw new DoctorNotFoundException("Invalid Doctor Id");
        }
        Person person = optionalPerson.get();
        Doctor doctor = optionalDoctor.get();

        Appointment appointment = new Appointment();
        appointment.setAppointmentId(UUID.randomUUID().toString());
        appointment.setPerson(person);
        appointment.setDoctor(doctor);

        Appointment savedAppointment = appointmentRepository.save(appointment);

        person.getAppointmentList().add(savedAppointment);
        doctor.getAppointmentList().add(savedAppointment);

        personRepository.save(person);
        doctorRepository.save(doctor);

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("mail.service939@gmail.com");
        simpleMailMessage.setTo(person.getEmailId());
        simpleMailMessage.setSubject("Congratulations! Appointment Booked");
        simpleMailMessage.setText("Congratulations! "+ person.getName() +
                " your Appointment has been booked for " + savedAppointment.getAppointmentDate() +
                " with " + doctor.getName() +
                " At " + doctor.getVaccinationCenter().getCenterName() +
                " " + doctor.getVaccinationCenter().getAddress());

        javaMailSender.send(simpleMailMessage);

        AppointmentResponseDto appointmentResponseDto = AppointmentTransformer.appoointmentToAppointmentResponseDto(savedAppointment);
        appointmentResponseDto.setMessage("Appointment Booking Successful");

        return appointmentResponseDto;


    }

    public List<AppointmentResponseDto> getAllAppointmentsForPerson(int personId) {
        List<AppointmentResponseDto> appointmentResponseDtoList = new ArrayList<>();

        Optional<Person> optionalPerson = personRepository.findById(personId);

        if(optionalPerson.isEmpty()){
            throw new PersonNotFoundException("Invalid Person Id");
        }

        Person person = optionalPerson.get();

        for(Appointment appointment: person.getAppointmentList()){
            appointmentResponseDtoList.add(AppointmentTransformer.appoointmentToAppointmentResponseDto(appointment));
        }
        return appointmentResponseDtoList;

    }

    public List<AppointmentResponseDto> getAllAppointmentsForDoctor(int doctorId) {

        Optional<Doctor> optionalDoctor = doctorRepository.findById(doctorId);

        if(optionalDoctor.isEmpty()){
            throw new DoctorNotFoundException("Invalid Doctor Id");
        }
        Doctor doctor = optionalDoctor.get();

        List<AppointmentResponseDto> appointmentResponseDtoList = new ArrayList<>();


        for(Appointment appointment: doctor.getAppointmentList()){
            appointmentResponseDtoList.add(AppointmentTransformer.appoointmentToAppointmentResponseDto(appointment));
        }
        return appointmentResponseDtoList;

    }
}

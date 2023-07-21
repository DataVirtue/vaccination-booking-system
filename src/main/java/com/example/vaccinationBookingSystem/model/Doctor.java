package com.example.vaccinationBookingSystem.model;


import com.example.vaccinationBookingSystem.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Doctor {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    int age;

    @Column(unique = true)
    String emailId;


    @Enumerated(value = EnumType.STRING)
    Gender gender;


    @ManyToOne
    @JoinColumn
    VaccinationCenter vaccinationCenter;

    @OneToMany(mappedBy = "doctor")
    List<Appointment> appointmentList = new ArrayList<>();

}

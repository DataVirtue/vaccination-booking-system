package com.example.vaccinationBookingSystem.models;


import com.example.vaccinationBookingSystem.Enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

}

package com.example.vaccinationBookingSystem.models;

import com.example.vaccinationBookingSystem.Enums.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level= AccessLevel.PRIVATE)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    int aadharCardNo;


    @Column(nullable = false)
    String name;

    @Column(unique = true, nullable = false)
    String emailId;

    @Enumerated(value = EnumType.STRING)
    Gender gender;
    boolean isDose1Taken = false;
    boolean isDose2Taken = false;

}

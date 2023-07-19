package com.example.vaccinationBookingSystem.model;

import com.example.vaccinationBookingSystem.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    List<Dose> doseList = new ArrayList<>();

}

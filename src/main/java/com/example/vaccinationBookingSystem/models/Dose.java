package com.example.vaccinationBookingSystem.models;


import com.example.vaccinationBookingSystem.Enums.DoseType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Dose {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(nullable = false, unique = true)
    String doseId;

    @Enumerated(value = EnumType.STRING)
    DoseType doseType;

    @ManyToOne
    @JoinColumn
    Person person;



}

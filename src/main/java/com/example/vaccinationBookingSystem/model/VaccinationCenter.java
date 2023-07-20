package com.example.vaccinationBookingSystem.model;


import com.example.vaccinationBookingSystem.Enum.CenterType;
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
public class VaccinationCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String centerName;

    @Enumerated(EnumType.STRING)
    CenterType centerType;

    String address;

    @OneToMany(mappedBy = "vaccinationCenter", cascade = CascadeType.ALL)
    List<Doctor> doctorList = new ArrayList<>();



}

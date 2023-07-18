package com.example.vaccinationBookingSystem.models;


import com.example.vaccinationBookingSystem.Enums.CenterType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.Mapping;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

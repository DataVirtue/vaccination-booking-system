package com.example.vaccinationBookingSystem.repository;

import com.example.vaccinationBookingSystem.model.VaccinationCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VaccinationCenterRepository extends JpaRepository<VaccinationCenter,Integer> {

}

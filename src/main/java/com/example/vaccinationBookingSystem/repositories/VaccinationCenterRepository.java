package com.example.vaccinationBookingSystem.repositories;

import com.example.vaccinationBookingSystem.models.VaccinationCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VaccinationCenterRepository extends JpaRepository<VaccinationCenter,Integer> {

}

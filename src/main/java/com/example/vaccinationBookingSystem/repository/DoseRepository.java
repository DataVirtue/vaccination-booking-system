package com.example.vaccinationBookingSystem.repository;

import com.example.vaccinationBookingSystem.model.Dose;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoseRepository extends JpaRepository<Dose,Integer> {

}

package com.example.vaccinationBookingSystem.repositories;

import com.example.vaccinationBookingSystem.models.Dose;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoseRepository extends JpaRepository<Dose,Integer> {

}

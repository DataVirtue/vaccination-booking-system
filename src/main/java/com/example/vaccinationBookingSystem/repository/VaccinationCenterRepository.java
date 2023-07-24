package com.example.vaccinationBookingSystem.repository;

import com.example.vaccinationBookingSystem.Enum.CenterType;
import com.example.vaccinationBookingSystem.model.Doctor;
import com.example.vaccinationBookingSystem.model.Person;
import com.example.vaccinationBookingSystem.model.VaccinationCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface VaccinationCenterRepository extends JpaRepository<VaccinationCenter,Integer> {

    @Query(value = "select doctor.* from doctor inner join vaccination_center where vaccination_center.center_type=:centerType", nativeQuery = true)
    List<Doctor> getAllDoctorsWithCenterType(String centerType);



}

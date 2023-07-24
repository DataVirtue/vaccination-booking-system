package com.example.vaccinationBookingSystem.repository;

import com.example.vaccinationBookingSystem.Enum.CenterType;
import com.example.vaccinationBookingSystem.model.Doctor;
import com.example.vaccinationBookingSystem.model.VaccinationCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface VaccinationCenterRepository extends JpaRepository<VaccinationCenter,Integer> {

    @Query(value = "select doctor.* from doctor inner join vaccination_center where vaccination_center.center_type=:centerType", nativeQuery = true)
    List<Doctor> getAllDoctorsWithCenterType(String centerType);

    @Query(value = "select vaccination_center.* from vaccination_center inner join doctor on doctor.vaccination_center_id=vaccination_center.id group by vaccination_center.id order by count(vaccination_center.id) desc limit 1",nativeQuery = true)
    VaccinationCenter getCenterWithHighestNoOfDoctors();


    @Query(value = "select vaccination_center.* from vaccination_center inner join doctor on doctor.vaccination_center_id=vaccination_center.id where center_type=:centerType group by vaccination_center.id order by count(vaccination_center.id) desc limit 1",nativeQuery = true)
    VaccinationCenter getCenterWithHighestNoOfDoctorsWithCenterType(String centerType);
}

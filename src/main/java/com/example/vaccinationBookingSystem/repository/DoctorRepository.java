package com.example.vaccinationBookingSystem.repository;

import com.example.vaccinationBookingSystem.model.Doctor;
import com.example.vaccinationBookingSystem.model.VaccinationCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Integer>{


    @Query(value = "select * from doctor where age> :age", nativeQuery = true)
    List<Doctor> getByAgeGreaterThan(@Param("age") int age);


    @Query(value = "select doctor.* from doctor inner join appointment on doctor.id=appointment.doctor_id group by doctor_id order by count(*) desc limit 1",nativeQuery = true)
    Doctor getDoctorWithHighestNoOfAppointments();

    List<Doctor> getDoctorByVaccinationCenter(VaccinationCenter vaccinationCenter);


}

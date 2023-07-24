package com.example.vaccinationBookingSystem.repository;

import com.example.vaccinationBookingSystem.Enum.CenterType;
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

    @Query(value = " select doctor.* from doctor inner join vaccination_center on doctor.vaccination_center_id=vaccination_center.id where vaccination_center.center_type=:centerType", nativeQuery = true)
    List<Doctor> getAllDoctorsWithCenterType(String centerType);

}

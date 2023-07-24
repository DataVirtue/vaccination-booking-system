package com.example.vaccinationBookingSystem.repository;

import com.example.vaccinationBookingSystem.model.Person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    public Person findByEmailId(String email);


    @Query(value = "select * from person where age > :age and gender='MALE'", nativeQuery = true)
    List<Person> getAllMalesGreaterThan(int age);

    @Query(value = "select * from person where dose1Taken = true and dose2Taken = false and gender='FEMALE'", nativeQuery = true)
    List<Person> getAllFemalesWithOneDoseTaken();

    @Query(value = "select * from person where dose1Taken = true and dose2Taken = true",nativeQuery = true)
    List<Person> getFullyVaccinatedPeople();

    @Query(value = "select * from person where dose1Taken = false and dose2Taken = false",nativeQuery = true)
   List<Person> getPeopleWithNoDoseTaken();

    @Query(value = "select * from person where dose1Taken = true and dose2Taken = false and gender='FEMALE' and age>:age", nativeQuery = true)
    List<Person> getAllFemalesWithOneDoseTakenAndAgeGreaterThan(int age);

    @Query(value = "select * from person where dose1Taken = true and dose2Taken = true and gender='MALE' and age>:age", nativeQuery = true)
   List<Person> getMalesWithBothDoseTakenAndAgeGreaterThan(int age);


}

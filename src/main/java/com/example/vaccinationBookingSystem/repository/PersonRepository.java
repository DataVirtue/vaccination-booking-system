package com.example.vaccinationBookingSystem.repository;

import com.example.vaccinationBookingSystem.model.Person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    public Person findByEmailId(String email);
}

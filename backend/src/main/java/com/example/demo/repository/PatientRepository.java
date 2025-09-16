package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entity.Patient;

public interface PatientRepository extends MongoRepository<Patient, String> {

}

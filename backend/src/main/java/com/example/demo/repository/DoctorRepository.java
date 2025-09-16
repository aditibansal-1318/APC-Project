package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entity.Doctor;

public interface DoctorRepository extends MongoRepository<Doctor, String> {

}

package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entity.Department;

public interface DepartmentRepository extends MongoRepository<Department, String> {

}

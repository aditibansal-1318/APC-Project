package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.Patient;
import com.example.demo.service.PatientService;

@RestController
@RequestMapping("/patients")
@CrossOrigin(origins = "*")
public class PatientController {

    @Autowired
    private PatientService service;

    @GetMapping
    public List<Patient> getAll() {
    	return service.getAll();
    }

    @GetMapping("/{id}")
    public Patient getById(@PathVariable String id) {
    	return service.getById(id);
    }

    @PostMapping
    public Patient add(@RequestBody Patient patient) {
    	return service.add(patient);
    }

    @PutMapping("/{id}")
    public Patient update(@PathVariable String id, @RequestBody Patient patient) {
    	return service.update(id, patient);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id) {
        return service.delete(id) ? "Deleted Successfully" : "Delete Failed";
    }
}

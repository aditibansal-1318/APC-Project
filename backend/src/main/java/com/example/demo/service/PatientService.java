package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Patient;
import com.example.demo.repository.PatientRepository;

@Service
public class PatientService {

    @Autowired
    private PatientRepository repo;

    public List<Patient> getAll() {
        try {
        	return repo.findAll();
        } catch (Exception e) {
        	System.out.println("Error: " + e);
        	return null;
        }
    }

    public Patient getById(String id) {
        try {
            return repo.findById(id).orElse(null);
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }

    public Patient add(Patient patient) {
        try {
            return repo.save(patient);
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }

    public boolean delete(String id) {
        try {
            repo.deleteById(id);
            return true;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return false;
        }
    }

    public Patient update(String id, Patient updated) {
        try {
            Optional<Patient> opt = repo.findById(id);
            if (opt.isPresent()) {
                Patient p = opt.get();
                p.setName(updated.getName());
                p.setAge(updated.getAge());
                p.setDisease(updated.getDisease());
                return repo.save(p);
            }
            return null;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }
}

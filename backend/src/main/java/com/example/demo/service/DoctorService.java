package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Doctor;
import com.example.demo.repository.DoctorRepository;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository repo;

    public List<Doctor> getAll() {
        try {
            return repo.findAll();
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }

    public Doctor getById(String id) {
        try {
            return repo.findById(id).orElse(null);
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }

    public Doctor add(Doctor doctor) {
        try {
            return repo.save(doctor);
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

    public Doctor update(String id, Doctor updated) {
        try {
            Optional<Doctor> opt = repo.findById(id);
            if (opt.isPresent()) {
                Doctor d = opt.get();
                d.setName(updated.getName());
                d.setDepartment(updated.getDepartment());
                d.setSpecialization(updated.getSpecialization());
                return repo.save(d);
            }
            return null;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }
}

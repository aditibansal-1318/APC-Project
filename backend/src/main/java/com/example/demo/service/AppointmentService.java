package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Appointment;
import com.example.demo.repository.AppointmentRepository;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository repo;

    public List<Appointment> getAll() {
        try {
            return repo.findAll();
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }

    public Appointment getById(String id) {
        try {
            return repo.findById(id).orElse(null);
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }

    public Appointment add(Appointment appointment) {
        try {
            return repo.save(appointment);
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

    public Appointment update(String id, Appointment updated) {
        try {
            Optional<Appointment> opt = repo.findById(id);
            if (opt.isPresent()) {
                Appointment a = opt.get();
                a.setPatientId(updated.getPatientId());
                a.setDoctorId(updated.getDoctorId());
                a.setDate(updated.getDate());
                a.setTime(updated.getTime());
                return repo.save(a);
            }
            return null;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }
}

package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.Doctor;
import com.example.demo.service.DoctorService;

@RestController
@RequestMapping("/doctors")
@CrossOrigin(origins = "*")
public class DoctorController {

    @Autowired
    private DoctorService service;

    @GetMapping
    public List<Doctor> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Doctor getById(@PathVariable String id) {
        return service.getById(id);
    }

    @PostMapping
    public Doctor add(@RequestBody Doctor doctor) {
        return service.add(doctor);
    }

    @PutMapping("/{id}")
    public Doctor update(@PathVariable String id, @RequestBody Doctor doctor) {
        return service.update(id, doctor);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id) {
        return service.delete(id) ? "Deleted Successfully" : "Delete Failed";
    }
}

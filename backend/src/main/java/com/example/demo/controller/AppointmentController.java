package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.Appointment;
import com.example.demo.service.AppointmentService;

@RestController
@RequestMapping("/appointments")
@CrossOrigin(origins = "*")
public class AppointmentController {

    @Autowired
    private AppointmentService service;

    @GetMapping
    public List<Appointment> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Appointment getById(@PathVariable String id) {
        return service.getById(id);
    }

    @PostMapping
    public Appointment add(@RequestBody Appointment appointment) {
        return service.add(appointment);
    }

    @PutMapping("/{id}")
    public Appointment update(@PathVariable String id, @RequestBody Appointment appointment) {
        return service.update(id, appointment);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id) {
        return service.delete(id) ? "Deleted Successfully" : "Delete Failed";
    }
}

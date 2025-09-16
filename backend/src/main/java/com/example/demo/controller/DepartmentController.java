package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.Department;
import com.example.demo.service.DepartmentService;

@RestController
@RequestMapping("/departments")
@CrossOrigin(origins = "*")
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    @GetMapping
    public List<Department> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Department getById(@PathVariable String id) {
        return service.getById(id);
    }

    @PostMapping
    public Department add(@RequestBody Department department) {
        return service.add(department);
    }

    @PutMapping("/{id}")
    public Department update(@PathVariable String id, @RequestBody Department department) {
        return service.update(id, department);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id) {
        return service.delete(id) ? "Deleted Successfully" : "Delete Failed";
    }
}

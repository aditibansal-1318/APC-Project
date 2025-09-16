package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Department;
import com.example.demo.repository.DepartmentRepository;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository repo;

    public List<Department> getAll() {
        try {
            return repo.findAll();
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }

    public Department getById(String id) {
        try {
            return repo.findById(id).orElse(null);
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }

    public Department add(Department department) {
        try {
            return repo.save(department);
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

    public Department update(String id, Department updated) {
        try {
            Optional<Department> opt = repo.findById(id);
            if (opt.isPresent()) {
                Department d = opt.get();
                d.setName(updated.getName());
                return repo.save(d);
            }
            return null;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }
}

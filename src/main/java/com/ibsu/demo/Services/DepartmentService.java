package com.ibsu.demo.Services;

import com.ibsu.demo.Entities.Department;
import com.ibsu.demo.Repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getAll() {
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(Long id) throws Exception {
        return departmentRepository.findById(id).orElseThrow(() -> new Exception("Department not found"));
    }

    public List<Department> getByName(String name){
        return departmentRepository.getByName(name);
    }
}

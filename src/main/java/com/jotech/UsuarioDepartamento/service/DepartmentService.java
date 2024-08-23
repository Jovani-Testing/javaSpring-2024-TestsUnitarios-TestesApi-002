package com.jotech.UsuarioDepartamento.service;

import com.jotech.UsuarioDepartamento.entities.Department;
import com.jotech.UsuarioDepartamento.entities.User;
import com.jotech.UsuarioDepartamento.repositories.DepartmentRepository;
import com.jotech.UsuarioDepartamento.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;
    public Department createDepartment(Department department) {
        if (department.getName() == null || department.getName().trim().isEmpty()) {throw new IllegalArgumentException("O campo 'Departamento' não pode ser nulo ou vazio.");
        }
        return departmentRepository.save(department);
    }
}

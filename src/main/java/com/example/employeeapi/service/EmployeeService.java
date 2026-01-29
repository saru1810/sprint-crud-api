package com.example.employeeapi.service;

import com.example.employeeapi.dto.EmployeeDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private List<EmployeeDTO> employees = new ArrayList<>();

    // CREATE
    public String addEmployee(EmployeeDTO employee) {
        employees.add(employee);
        return "Employee added";
    }

    // READ
    public List<EmployeeDTO> getAllEmployees() {
        return employees;
    }

    // UPDATE
    public String updateEmployee(int id, String name) {
        for (EmployeeDTO e : employees) {
            if (e.getId() == id) {
                e.setName(name);
                return "Employee updated";
            }
        }
        return "Employee not found";
    }

    // DELETE
    public String deleteEmployee(int id) {
        employees.removeIf(e -> e.getId() == id);
        return "Employee deleted";
    }
}


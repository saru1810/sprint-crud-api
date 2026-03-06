package com.example.employeeapi.service;

import com.example.employeeapi.dto.EmployeeDTO;
import com.example.employeeapi.entity.Employee;
import com.example.employeeapi.repository.EmployeeRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    private final EmployeeRepository repository;

    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public String addEmployee(EmployeeDTO dto) {

        logger.info("Adding new employee with email: {}", dto.getEmail());

        Employee employee = new Employee();
        employee.setName(dto.getName());
        employee.setEmail(dto.getEmail());
        employee.setRole(dto.getRole());

        repository.save(employee);

        logger.info("Employee saved successfully");

        return "Employee created successfully";
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {

        logger.info("Fetching all employees");

        return repository.findAll()
                .stream()
                .map(e -> new EmployeeDTO(e.getName(), e.getEmail(), e.getRole()))
                .toList();
    }

    @Override
    public String updateEmployee(Long id, String name) {

        logger.info("Updating employee with id {}", id);

        Employee employee = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        employee.setName(name);
        repository.save(employee);

        logger.info("Employee updated successfully");

        return "Employee updated successfully";
    }

    @Override
    public String deleteEmployee(Long id) {

        logger.warn("Deleting employee with id {}", id);

        repository.deleteById(id);

        logger.info("Employee deleted successfully");

        return "Employee deleted successfully";
    }
}
package com.example.employeeapi.service;

import com.example.employeeapi.dto.EmployeeDTO;
import java.util.List;

public interface EmployeeService {

    String addEmployee(EmployeeDTO employeeDTO);

    List<EmployeeDTO> getAllEmployees();

    String updateEmployee(Long id, String name);

    String deleteEmployee(Long id);
}




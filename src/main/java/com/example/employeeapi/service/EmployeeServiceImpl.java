
package com.example.employeeapi.service;
import com.example.employeeapi.dto.EmployeeDTO;
import com.example.employeeapi.entity.Employee;
import com.example.employeeapi.repository.EmployeeRepository;
import org.springframework.stereotype.Service;




import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public String addEmployee(EmployeeDTO dto) {
        Employee employee = new Employee();
        employee.setName(dto.getName());
        employee.setEmail(dto.getEmail());
        employee.setRole(dto.getRole());

        repository.save(employee);
        return "Employee created successfully";
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return repository.findAll()
                .stream()
                .map(e -> new EmployeeDTO(e.getName(), e.getEmail(), e.getRole()))
                .toList();
    }

    @Override
    public String updateEmployee(Long id, String name) {
        Employee employee = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        employee.setName(name);
        repository.save(employee);
        return "Employee updated successfully";
    }

    @Override
    public String deleteEmployee(Long id) {
        repository.deleteById(id);
        return "Employee deleted successfully";
    }
}



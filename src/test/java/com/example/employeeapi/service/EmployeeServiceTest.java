package com.example.employeeapi.service;

import com.example.employeeapi.dto.EmployeeDTO;
import com.example.employeeapi.entity.Employee;
import com.example.employeeapi.repository.EmployeeRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmployeeServiceTest {

    @Mock
    private EmployeeRepository repository;

    @InjectMocks
    private EmployeeServiceImpl service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllEmployees() {

        Employee emp = new Employee();
        emp.setId(1L);
        emp.setName("Arun");
        emp.setEmail("arun@test.com");
        emp.setRole("Developer");

        when(repository.findAll()).thenReturn(List.of(emp));

        List<EmployeeDTO> employees = service.getAllEmployees();

        assertEquals(1, employees.size());
        assertEquals("Arun", employees.get(0).getName());
        assertEquals("Developer", employees.get(0).getRole());

        verify(repository, times(1)).findAll();
    }
}
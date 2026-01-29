package com.example.employeeapi.controller;

import com.example.employeeapi.dto.EmployeeDTO;
import com.example.employeeapi.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<String> createEmployee(@RequestBody EmployeeDTO employee) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.addEmployee(employee));
    }

    // READ
    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getEmployees() {
        return ResponseEntity.ok(service.getAllEmployees());
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<String> updateEmployee(
            @PathVariable int id,
            @RequestParam String name) {

        return ResponseEntity.ok(service.updateEmployee(id, name));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id) {
        return ResponseEntity.ok(service.deleteEmployee(id));
    }
}

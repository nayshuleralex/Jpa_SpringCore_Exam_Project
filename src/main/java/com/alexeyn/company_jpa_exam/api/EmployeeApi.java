package com.alexeyn.company_jpa_exam.api;

import com.alexeyn.company_jpa_exam.entities.Employee;
import com.alexeyn.company_jpa_exam.logic.EmployeeController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeApi {

    @Autowired
    private EmployeeController employeeController;

    // Create
    @PostMapping
    public void createEmployee(@RequestBody Employee employee) {
        this.employeeController.createEmployee(employee);
    }

    // Read
    @GetMapping("/{employeeId}")
    public Employee getEmployee(@PathVariable("employeeId") long employeeId) {
        return this.employeeController.getEmployee(employeeId);
    }

    @GetMapping("/byName")
    public List<Employee> getEmployeesByName(@RequestParam("name") String name) {
        return this.employeeController.getEmployeesByName(name);
    }

    // Read All
    @GetMapping
    public List<Employee> getAllEmployees() {
        return this.employeeController.getAllEmployees();
    }

    // Update
    @PutMapping
    public void updateEmployee(@RequestBody Employee employee) {
        this.employeeController.updateEmployee(employee);
    }

    @PutMapping("/addJobForEmployee")
    public void addJobForEmployee(@RequestParam("employeeId") Long employeeId, @RequestParam("jobId") Long jobId) {
        this.employeeController.addJobForEmployee(employeeId, jobId);
    }

    // Delete
    @DeleteMapping("/{employeeId}")
    public void deleteEmployee(@PathVariable long employeeId) {
        this.employeeController.deleteEmployee(employeeId);
    }
}

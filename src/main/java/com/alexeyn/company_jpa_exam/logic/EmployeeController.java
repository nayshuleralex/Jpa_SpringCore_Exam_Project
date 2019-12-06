package com.alexeyn.company_jpa_exam.logic;

import com.alexeyn.company_jpa_exam.dao.IEmployeeDao;
import com.alexeyn.company_jpa_exam.entities.Employee;
import com.alexeyn.company_jpa_exam.entities.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.transaction.Transactional;
import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private IEmployeeDao employeeDao;

    @Autowired
    private JobController jobController;

    // Create
    @Transactional
    public void createEmployee(Employee employee) {
        for (Job j : employee.getJobs()) {
            j.setEmployee(employee);
        }
        this.employeeDao.save(employee);
    }

    @Transactional
    public void addJobForEmployee(Long employeeId, Long jobId) {
        Job job = this.jobController.getJob(jobId);
        Employee employee = this.getEmployee(employeeId);
        job.setEmployee(employee);
        this.jobController.updateJob(job);
    }

    // Read
    public Employee getEmployee(long employeeId) {
        return this.employeeDao.findById(employeeId).get();
    }

    //ReadByName
    public List<Employee> getEmployeesByName(String name) {
        return this.employeeDao.findEmployeesByName(name);
    }

    // Read All
    public List<Employee> getAllEmployees() {
        return (List<Employee>) this.employeeDao.findAll();
    }

    // Update
    public void updateEmployee(Employee employee) {
        this.employeeDao.save(employee);
    }

    // Delete
    public void deleteEmployee(long employeeId) {
        this.employeeDao.deleteById(employeeId);
    }
}

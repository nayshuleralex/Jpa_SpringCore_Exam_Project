package com.alexeyn.company_jpa_exam.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "EMPLOYEES")
public class Employee {

    @Id
    @GeneratedValue
    @Column(name = "EMPLOYEE_ID")
    private Long employeeId;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "SALARY", nullable = false)
    private float salary;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<Job> jobs;

    public Employee() {
    }

    public Employee(String name, float salary, List<Job> jobs) {
        this.name = name;
        this.salary = salary;
        this.jobs = jobs;
    }

    public Employee(Long employeeId, String name, float salary, List<Job> jobs) {
        this(name, salary, jobs);
        this.employeeId = employeeId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }
}

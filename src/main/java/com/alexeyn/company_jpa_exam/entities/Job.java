package com.alexeyn.company_jpa_exam.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
@Table(name = "JOBS")
public class Job {

    @Id
    @GeneratedValue
    @Column(name = "JOB_ID")
    private Long jobId;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @Column(name = "DEAD_LINE", nullable = false)
    private Date deadLine;

    @ManyToOne()
    @JsonIgnore
    private Employee employee;

    public Job() {
    }

    public Job(String description, Date deadLine) {
        this.description = description;
        this.deadLine = deadLine;
    }

    public Job(String description, Date deadLine, Employee employee) {
        this.description = description;
        this.deadLine = deadLine;
        this.employee = employee;
    }

    public Job(Long jobId, String description, Date deadLine, Employee employee) {
        this(description, deadLine, employee);
        this.jobId = jobId;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(Date deadLine) {
        this.deadLine = deadLine;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}

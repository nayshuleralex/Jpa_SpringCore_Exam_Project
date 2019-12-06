package com.alexeyn.company_jpa_exam.logic;

import com.alexeyn.company_jpa_exam.dao.IJobDao;
import com.alexeyn.company_jpa_exam.entities.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.sql.Date;
import java.util.List;

@Controller
public class JobController {

    @Autowired
    private IJobDao jobDao;

    // Create
    public void createJob(Job job) {
        this.jobDao.save(job);
    }

    // Read
    public Job getJob(long jobId) {
        return this.jobDao.findById(jobId).get();
    }

    // Read All
    public List<Job> getAllJobs() {
        return (List<Job>) this.jobDao.findAll();
    }

    // Update
    public void updateJob(Job job) {
        this.jobDao.save(job);
    }

    // Delete
    public void deleteJob(long jobId) {
        this.jobDao.deleteById(jobId);
    }

    public List<Job> getJobsByDeadLine(Date deadLine) {
        return this.jobDao.findJobsByDeadLine(deadLine);
    }

    public List<Job> getJobsBetweenDeadLines(Date startDeadLine, Date endDeadLine) {
        return this.jobDao.findJobsBetweenDeadLines(startDeadLine, endDeadLine);
    }
}

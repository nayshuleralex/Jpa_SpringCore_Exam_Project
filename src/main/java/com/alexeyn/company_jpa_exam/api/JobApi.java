package com.alexeyn.company_jpa_exam.api;

import com.alexeyn.company_jpa_exam.entities.Job;
import com.alexeyn.company_jpa_exam.logic.JobController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobApi {

    @Autowired
    private JobController jobController;

    // Create
    @PostMapping
    public void createJob(@RequestBody Job job) {
        this.jobController.createJob(job);
    }

    // Read
    @GetMapping("/{jobId}")
    public Job getJob(@PathVariable long jobId) {
        return this.jobController.getJob(jobId);
    }

    @GetMapping("/getJobsByDeadLine")
    public List<Job> getJobsByDeadLine(@RequestParam Date deadLine) {
        return this.jobController.getJobsByDeadLine(deadLine);
    }

    @GetMapping("/getJobsBetweenDeadLines")
    public List<Job> getJobsBetweenDeadLines(@RequestParam Date startDeadLine, @RequestParam Date endDeadLine) {
        return this.jobController.getJobsBetweenDeadLines(startDeadLine, endDeadLine);
    }

    // Read All
    @GetMapping
    public List<Job> getAllJobs() {
        return this.jobController.getAllJobs();
    }

    // Update
    @PutMapping
    public void updateJob(@RequestBody Job job) {
        this.jobController.updateJob(job);
    }

    // Delete
    @DeleteMapping("/{jobId}")
    public void deleteJob(@PathVariable long jobId) {
        this.jobController.deleteJob(jobId);
    }
}

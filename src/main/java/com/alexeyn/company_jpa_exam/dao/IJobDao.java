package com.alexeyn.company_jpa_exam.dao;

import com.alexeyn.company_jpa_exam.entities.Job;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface IJobDao extends CrudRepository<Job, Long> {

    @Query("SELECT j FROM Job j WHERE j.deadLine = :deadLine")
    List<Job> findJobsByDeadLine(@Param("deadLine") Date deadLine);

    @Query("SELECT j FROM Job j WHERE j.deadLine BETWEEN :startDeadLine AND :endDeadLine")
    List<Job> findJobsBetweenDeadLines(@Param("startDeadLine") Date startDeadLine, @Param("endDeadLine") Date endDeadLine);
}

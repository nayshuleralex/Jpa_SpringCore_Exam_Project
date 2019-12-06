package com.alexeyn.company_jpa_exam.dao;

import com.alexeyn.company_jpa_exam.entities.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IEmployeeDao extends CrudRepository<Employee, Long> {

    @Query("SELECT e FROM Employee e WHERE e.name = :name")
    List<Employee> findEmployeesByName(@Param("name") String name);
}

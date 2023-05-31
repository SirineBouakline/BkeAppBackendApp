package com.bke.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.bke.app.model.Employee;

@RepositoryRestResource
public interface EmployeeRepository extends JpaRepository<Employee, Long>  {

}

package com.stdev.AgileWay.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stdev.AgileWay.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	Optional<Employee> findByEmailContainingIgnoreCase(String email);
	
	Page<Employee> findByLastNameContainingIgnoreCase(String lastName, Pageable pageable);
}

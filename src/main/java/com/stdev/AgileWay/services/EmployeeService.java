package com.stdev.AgileWay.services;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;

import com.stdev.AgileWay.exceptions.AlreadyExistException;
import com.stdev.AgileWay.exceptions.NotFoundException;
import com.stdev.AgileWay.models.requests.EmployeeRequest;
import com.stdev.AgileWay.models.responses.EmployeeResponse;

public interface EmployeeService {

	EmployeeResponse add(EmployeeRequest employeeRequest) throws AlreadyExistException;
	
	List<EmployeeResponse> getAll();
	
	EmployeeResponse get(Long id) throws NotFoundException;
	
	void delete(Long id) throws NotFoundException;
	
	EmployeeResponse update(Long id, EmployeeRequest employeeRequest) throws NotFoundException;
	
	Map<String, Object> searchByName(String lastName, Pageable pageable);
}

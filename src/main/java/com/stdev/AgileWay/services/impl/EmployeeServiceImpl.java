package com.stdev.AgileWay.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stdev.AgileWay.exceptions.AlreadyExistException;
import com.stdev.AgileWay.exceptions.NotFoundException;
import com.stdev.AgileWay.models.requests.EmployeeRequest;
import com.stdev.AgileWay.models.responses.EmployeeResponse;
import com.stdev.AgileWay.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Override
	public EmployeeResponse add(EmployeeRequest employeeRequest) throws AlreadyExistException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeResponse> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeeResponse get(Long id) throws NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) throws NotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EmployeeResponse update(Long id, EmployeeRequest employeeRequest) throws NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}

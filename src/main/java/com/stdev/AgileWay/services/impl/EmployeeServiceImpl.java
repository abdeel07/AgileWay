package com.stdev.AgileWay.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.stdev.AgileWay.entities.Employee;
import com.stdev.AgileWay.entities.Event;
import com.stdev.AgileWay.exceptions.AlreadyExistException;
import com.stdev.AgileWay.exceptions.NotFoundException;
import com.stdev.AgileWay.mappers.EmployeeMapper;
import com.stdev.AgileWay.models.requests.EmployeeRequest;
import com.stdev.AgileWay.models.responses.EmployeeResponse;
import com.stdev.AgileWay.repositories.EmployeeRepository;
import com.stdev.AgileWay.repositories.TeamRepository;
import com.stdev.AgileWay.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	TeamRepository teamRepository;
	
	@Transactional
	@Override
	public EmployeeResponse add(EmployeeRequest employeeRequest) throws AlreadyExistException {
		Optional<Employee> findEmployee = employeeRepository.
				findByEmailContainingIgnoreCase(employeeRequest.getEmail());
		
		if(findEmployee.isPresent()) {
			throw new AlreadyExistException(Employee.class.getSimpleName());
		}
		
		Employee employee = EmployeeMapper.INSTANCE.employeeRequestToEmployee(employeeRequest);
		employee.setTeam(teamRepository.findById(employeeRequest.getTeamId()).get());
		employee.setEvents(new HashSet<Event>());
		
		return EmployeeMapper.INSTANCE.employeeToEmployeeResponse(employeeRepository.save(employee));
	}

	@Override
	public List<EmployeeResponse> getAll() {
		
		return EmployeeMapper.INSTANCE.mapEmployee(employeeRepository.findAll());
	}

	@Override
	public EmployeeResponse get(Long id) throws NotFoundException {
		Optional<Employee> findEmployee = employeeRepository.findById(id);
		
		if(findEmployee.isEmpty()) {
			throw new NotFoundException(Employee.class.getSimpleName());
		}
		
		return EmployeeMapper.INSTANCE.employeeToEmployeeResponse
				(employeeRepository.findById(id).get());
	}

	@Override
	public void delete(Long id) throws NotFoundException {
		Optional<Employee> findEmployee = employeeRepository.findById(id);
		
		if(findEmployee.isEmpty()) {
			throw new NotFoundException(Employee.class.getSimpleName());
		}
		
		employeeRepository.deleteById(id);
	}
	
	@Override
	public EmployeeResponse update(Long id, EmployeeRequest employeeRequest) throws NotFoundException {
		Optional<Employee> findEmployee = employeeRepository.findById(id);
		
		if(findEmployee.isEmpty()) {
			throw new NotFoundException(Employee.class.getSimpleName());
		}
		
		Employee employee = employeeRepository.findById(id).get();
		employee.setEmail(employeeRequest.getEmail());
		employee.setFirstName(employeeRequest.getFirstName());
		employee.setLastName(employeeRequest.getLastName());
		employee.setPhoneNumber(employeeRequest.getPhoneNumber());
		
		employee.setTeam(teamRepository.findById(employeeRequest.getTeamId()).get());
		
		return EmployeeMapper.INSTANCE.employeeToEmployeeResponse(employeeRepository.save(employee));
	}

	@Override
	public Map<String, Object> searchByName(String lastName, Pageable pageable) {

		List<EmployeeResponse> employeeResponses = new ArrayList<>();
		Page<Employee> employees = (lastName.isBlank()) ? employeeRepository.findAll(pageable)
				: employeeRepository.findByLastNameContainingIgnoreCase(lastName, pageable);
		
		employees.forEach(e -> {
			EmployeeResponse response = EmployeeResponse.builder().id(e.getId()).firstName(e.getFirstName())
					.lastName(e.getLastName()).email(e.getEmail()).phoneNumber(e.getPhoneNumber()).build();
			employeeResponses.add(response);
		});
		
		Map<String, Object> page = new HashMap<>();
		page.put("content", employeeResponses);
		page.put("currentPage", employees.getNumber());
		page.put("totalElements", employees.getTotalElements());
		page.put("totalPages", employees.getTotalPages());
		
		return page;
	}

}

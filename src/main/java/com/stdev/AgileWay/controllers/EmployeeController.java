package com.stdev.AgileWay.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stdev.AgileWay.exceptions.AlreadyExistException;
import com.stdev.AgileWay.exceptions.NotFoundException;
import com.stdev.AgileWay.models.requests.EmployeeRequest;
import com.stdev.AgileWay.models.responses.EmployeeResponse;
import com.stdev.AgileWay.services.EmployeeService;

@RestController
@RequestMapping("/api/employee")
@CrossOrigin(origins = { "http://localhost:4200" })
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@PostMapping
	public ResponseEntity<EmployeeResponse> add(@RequestBody @Valid EmployeeRequest employeeRequest)
			throws AlreadyExistException{
		EmployeeResponse response = employeeService.add(employeeRequest);
		
		return new ResponseEntity<EmployeeResponse>(response, HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<EmployeeResponse>> getAll(){
		return new ResponseEntity<List<EmployeeResponse>>(employeeService.getAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EmployeeResponse> get(@PathVariable Long id)
			throws NotFoundException{
		return new ResponseEntity<EmployeeResponse>(employeeService.get(id), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) 
			throws NotFoundException{
		employeeService.delete(id);
		return new ResponseEntity<String>("Deleted !", HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<EmployeeResponse> update(@PathVariable Long id, @RequestBody @Valid
			EmployeeRequest employeeRequest) throws NotFoundException{
		
		return new ResponseEntity<EmployeeResponse>(employeeService.update(id, employeeRequest),
				HttpStatus.OK);
	}
}

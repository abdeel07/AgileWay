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
import com.stdev.AgileWay.models.requests.SubTaskRequest;
import com.stdev.AgileWay.models.responses.SubTaskResponse;
import com.stdev.AgileWay.services.SubTaskService;

@RestController
@RequestMapping("/api/subtask")
@CrossOrigin(origins = { "http://localhost:4200" })
public class SubTaskController {

	@Autowired
	SubTaskService service;
	
	@PostMapping
	public ResponseEntity<SubTaskResponse> add(@RequestBody @Valid SubTaskRequest request)
			throws AlreadyExistException{
		SubTaskResponse response = service.add(request);
		
		return new ResponseEntity<SubTaskResponse>(response, HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<SubTaskResponse>> getAll(){
		return new ResponseEntity<List<SubTaskResponse>>(service.getAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<SubTaskResponse> get(@PathVariable Long id)
			throws NotFoundException {
		return new ResponseEntity<SubTaskResponse>(service.get(id), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id)
			throws NotFoundException{
		service.delete(id);
		return new ResponseEntity<String>("Deleted !", HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<SubTaskResponse> update(@PathVariable Long id,
			@RequestBody @Valid SubTaskRequest request) throws NotFoundException{
		return new ResponseEntity<SubTaskResponse>(service.update(id, request),HttpStatus.OK);
	}
}

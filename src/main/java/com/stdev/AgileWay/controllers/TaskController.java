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
import com.stdev.AgileWay.models.requests.TaskRequest;
import com.stdev.AgileWay.models.responses.TaskResponse;
import com.stdev.AgileWay.services.TaskService;

@RestController
@RequestMapping("/api/task")
@CrossOrigin(origins = { "http://localhost:4200" })
public class TaskController {

	@Autowired
	TaskService taskService;
	
	@PostMapping
	public ResponseEntity<TaskResponse> add(@RequestBody @Valid TaskRequest taskRequest)
			throws AlreadyExistException{
		TaskResponse taskResponse = taskService.add(taskRequest);
		
		return new ResponseEntity<TaskResponse>(taskResponse, HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<TaskResponse>> getAll(){
		
		return new ResponseEntity<List<TaskResponse>>(taskService.getAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TaskResponse> get(@PathVariable Long id) 
			throws NotFoundException{
		
		return new ResponseEntity<TaskResponse>(taskService.get(id), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) 
			throws NotFoundException{
		taskService.delete(id);
		return new ResponseEntity<String>("Deleted !", HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<TaskResponse> update(@PathVariable Long id, 
			@RequestBody @Valid TaskRequest taskRequest) 
					throws NotFoundException, AlreadyExistException{
		
		return new ResponseEntity<TaskResponse>(taskService.update(id, taskRequest), HttpStatus.OK);
	}
}

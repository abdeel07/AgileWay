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
import com.stdev.AgileWay.models.requests.TeamRequest;
import com.stdev.AgileWay.models.responses.TeamResponse;
import com.stdev.AgileWay.services.TeamService;

@RestController
@RequestMapping("/api/team")
@CrossOrigin(origins = { "http://localhost:4200" })
public class TeamController {

	@Autowired
	TeamService teamService;
	
	@PostMapping
	public ResponseEntity<TeamResponse> add(@RequestBody @Valid TeamRequest teamRequest)
			throws AlreadyExistException{
		TeamResponse response = teamService.add(teamRequest);
		
		return new ResponseEntity<TeamResponse>(response, HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<TeamResponse>> getAll(){
		return new ResponseEntity<>(teamService.getAll(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TeamResponse> getOne(@PathVariable("id") Long id)
			throws NotFoundException{
		return new ResponseEntity<TeamResponse>(teamService.get(id), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Long id)
			throws NotFoundException{
		teamService.delete(id);
		return new ResponseEntity<String>("Deleted !", HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<TeamResponse> update(@PathVariable("id") Long id,
			@RequestBody @Valid TeamRequest teamRequest) throws NotFoundException{
		return new ResponseEntity<TeamResponse>(teamService.update(id, teamRequest), HttpStatus.OK);
	}
}

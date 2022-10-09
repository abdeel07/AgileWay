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
import com.stdev.AgileWay.models.requests.EventRequest;
import com.stdev.AgileWay.models.responses.EventResponse;
import com.stdev.AgileWay.services.EventService;

@RestController
@RequestMapping("/api/event")
@CrossOrigin(origins = { "http://localhost:4200" })
public class EventController {

	@Autowired
	EventService eventService;
	
	@PostMapping
	public ResponseEntity<EventResponse> add(@RequestBody @Valid EventRequest eventRequest)
			throws AlreadyExistException{
		EventResponse eventResponse = eventService.add(eventRequest);
		
		return new ResponseEntity<EventResponse>(eventResponse, HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<EventResponse>> getAll(){
		return new ResponseEntity<List<EventResponse>>(eventService.getAll(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EventResponse> get(@PathVariable Long id)
			throws NotFoundException{
		return new ResponseEntity<EventResponse>(eventService.get(id),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id)
			throws NotFoundException{
		eventService.delete(id);
		return new ResponseEntity<String>("Deleted !", HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<EventResponse> update(@PathVariable Long id,
			@RequestBody @Valid EventRequest eventRequest) throws NotFoundException{
		return new ResponseEntity<EventResponse>(eventService.update(id, eventRequest),
				HttpStatus.OK);
	}
}

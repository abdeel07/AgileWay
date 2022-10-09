package com.stdev.AgileWay.services;

import java.util.List;

import com.stdev.AgileWay.exceptions.AlreadyExistException;
import com.stdev.AgileWay.exceptions.NotFoundException;
import com.stdev.AgileWay.models.requests.EventRequest;
import com.stdev.AgileWay.models.responses.EventResponse;

public interface EventService {

	EventResponse add(EventRequest eventRequest) throws AlreadyExistException;
	
	List<EventResponse> getAll();
	
	EventResponse get(Long id) throws NotFoundException;
	
	void delete(Long id) throws NotFoundException;
	
	EventResponse update(Long id, EventRequest eventRequest) throws NotFoundException;
}

package com.stdev.AgileWay.services.impl;

import java.util.List;

import com.stdev.AgileWay.exceptions.AlreadyExistException;
import com.stdev.AgileWay.exceptions.NotFoundException;
import com.stdev.AgileWay.models.requests.EventRequest;
import com.stdev.AgileWay.models.responses.EventResponse;
import com.stdev.AgileWay.services.EventService;

public class EventServiceImpl implements EventService {

	@Override
	public EventResponse add(EventRequest eventRequest) throws AlreadyExistException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EventResponse> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EventResponse get(Long id) throws NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) throws NotFoundException {
		// TODO Auto-generated method stub

	}

	@Override
	public EventResponse update(Long id, EventRequest eventRequest) throws NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}

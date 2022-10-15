package com.stdev.AgileWay.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stdev.AgileWay.entities.Event;
import com.stdev.AgileWay.exceptions.AlreadyExistException;
import com.stdev.AgileWay.exceptions.NotFoundException;
import com.stdev.AgileWay.mappers.EventMapper;
import com.stdev.AgileWay.models.requests.EventRequest;
import com.stdev.AgileWay.models.responses.EventResponse;
import com.stdev.AgileWay.repositories.EmployeeRepository;
import com.stdev.AgileWay.repositories.EventRepository;
import com.stdev.AgileWay.repositories.TaskRepository;
import com.stdev.AgileWay.services.EventService;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	EventRepository eventRepository;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	TaskRepository taskRepository;
	
	@Override
	public EventResponse add(EventRequest eventRequest) throws AlreadyExistException {
		Event event = EventMapper.INSTANCE.eventRequestToEvent(eventRequest);
		
		event.setEmployee(employeeRepository.findById(eventRequest.getEmployeeId()).get());
		event.setTask(taskRepository.findById(eventRequest.getTaskId()).get());
		
		EventResponse response = EventMapper.INSTANCE.eventToEventResponse(eventRepository.save(event));
		response.setEmployeeName(event.getEmployee().getLastName()
				+ " " + event.getEmployee().getFirstName());
		
		return response;
	}

	@Override
	public List<EventResponse> getAll() {
		
		return EventMapper.INSTANCE.mapEvent(eventRepository.findAll());
	}

	@Override
	public EventResponse get(Long id) throws NotFoundException {
		Optional<Event> findEvent = eventRepository.findById(id);
		if(findEvent.isEmpty()) {
			throw new NotFoundException(Event.class.getSimpleName());
		}
		
		EventResponse response = EventMapper.INSTANCE.eventToEventResponse(findEvent.get());
		response.setEmployeeName(findEvent.get().getEmployee().getLastName()
				+ " " + findEvent.get().getEmployee().getFirstName());
		
		return response;
	}

	@Override
	public void delete(Long id) throws NotFoundException {
		Optional<Event> findEvent = eventRepository.findById(id);
		if(findEvent.isEmpty()) {
			throw new NotFoundException(Event.class.getSimpleName());
		}

		eventRepository.deleteById(id);
	}

	@Override
	public EventResponse update(Long id, EventRequest eventRequest) throws NotFoundException {
		Optional<Event> findEvent = eventRepository.findById(id);
		if(findEvent.isEmpty()) {
			throw new NotFoundException(Event.class.getSimpleName());
		}
		
		findEvent.get().setDate(eventRequest.getDate());
		findEvent.get().setType(eventRequest.getType());
		findEvent.get().setEmployee(employeeRepository.findById(eventRequest.getEmployeeId()).get());
		findEvent.get().setTask(taskRepository.findById(eventRequest.getTaskId()).get());
		
		EventResponse response = EventMapper.INSTANCE.eventToEventResponse(eventRepository.save(findEvent.get()));
		response.setEmployeeName(findEvent.get().getEmployee().getLastName()
				+ " " + findEvent.get().getEmployee().getFirstName());
		
		return response;
	}

}

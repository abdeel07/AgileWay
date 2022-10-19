package com.stdev.AgileWay.services.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stdev.AgileWay.entities.Task;
import com.stdev.AgileWay.entities.enums.EType;
import com.stdev.AgileWay.exceptions.AlreadyExistException;
import com.stdev.AgileWay.exceptions.NotFoundException;
import com.stdev.AgileWay.mappers.TaskMapper;
import com.stdev.AgileWay.models.requests.EventRequest;
import com.stdev.AgileWay.models.requests.TaskRequest;
import com.stdev.AgileWay.models.responses.TaskResponse;
import com.stdev.AgileWay.repositories.TaskRepository;
import com.stdev.AgileWay.repositories.TeamRepository;
import com.stdev.AgileWay.services.EventService;
import com.stdev.AgileWay.services.TaskService;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	TaskRepository taskRepository;
	
	@Autowired
	TeamRepository teamRepository;
	
	@Autowired
	EventService eventService;
	
	@Override
	public TaskResponse add(TaskRequest taskRequest) throws AlreadyExistException {
		Optional<Task> findTask = taskRepository.findByTitle(taskRequest.getTitle());
		if(findTask.isPresent()) {
			throw new AlreadyExistException(Task.class.getSimpleName());
		}
		
		Task task = TaskMapper.INSTANCE.taskRequestToTask(taskRequest);
		
		task.setTeam(teamRepository.findById(taskRequest.getTeamId()).get());
		
		task = taskRepository.save(task);
		
		EventRequest eventRequest = EventRequest.builder().type(EType.Created)
				.date(taskRequest.getCreationDate())
				.employeeId(taskRequest.getEmployeeId())
				.taskId(task.getId()).build();
		
		eventService.add(eventRequest);
		
		return TaskMapper.INSTANCE.taskToTaskResponse(task);
	}

	@Override
	public List<TaskResponse> getAll() {
		
		return TaskMapper.INSTANCE.mapTask(taskRepository.findAll());
	}

	@Override
	public TaskResponse get(Long id) throws NotFoundException {
		Optional<Task> findTask = taskRepository.findById(id);
		if(findTask.isEmpty()) {
			throw new NotFoundException(Task.class.getSimpleName());
		}
		
		return TaskMapper.INSTANCE.taskToTaskResponse(findTask.get());
	}

	@Override
	public void delete(Long id) throws NotFoundException {
		Optional<Task> findTask = taskRepository.findById(id);
		if(findTask.isEmpty()) {
			throw new NotFoundException(Task.class.getSimpleName());
		}
		
		taskRepository.deleteById(id);
	}

	@Override
	public TaskResponse update(Long id, TaskRequest taskRequest) throws NotFoundException, AlreadyExistException {
		Optional<Task> findTask = taskRepository.findById(id);
		if(findTask.isEmpty()) {
			throw new NotFoundException(Task.class.getSimpleName());
		}
		
		findTask.get().setTitle(taskRequest.getTitle());
		findTask.get().setDescription(taskRequest.getDescription());
		findTask.get().setCreationDate(taskRequest.getCreationDate());
		findTask.get().setEndDate(taskRequest.getEndDate());
		findTask.get().setStatus(taskRequest.getStatus());
		findTask.get().setLabel(taskRequest.getLabel());
		findTask.get().setStartDate(taskRequest.getStartDate());
		
		findTask.get().setTeam(teamRepository.findById(taskRequest.getTeamId()).get());
		
		
		EventRequest eventRequest = EventRequest.builder().type(EType.Updated)
				.date(new Date())
				.employeeId(taskRequest.getEmployeeId())
				.taskId(id).build();
		
		eventService.add(eventRequest);
		
		return TaskMapper.INSTANCE.taskToTaskResponse(taskRepository.save(findTask.get()));
	}

}

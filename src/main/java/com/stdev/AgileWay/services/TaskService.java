package com.stdev.AgileWay.services;

import java.util.List;

import com.stdev.AgileWay.exceptions.AlreadyExistException;
import com.stdev.AgileWay.exceptions.NotFoundException;
import com.stdev.AgileWay.models.requests.TaskRequest;
import com.stdev.AgileWay.models.responses.TaskResponse;

public interface TaskService {

	TaskResponse add(TaskRequest taskRequest) throws AlreadyExistException;
	
	List<TaskResponse> getAll();
	
	TaskResponse get(Long id) throws NotFoundException;
	
	void delete(Long id) throws NotFoundException;
	
	TaskResponse update(Long id, TaskRequest taskRequest) throws NotFoundException;
}

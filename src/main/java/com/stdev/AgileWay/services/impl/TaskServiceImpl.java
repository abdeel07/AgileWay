package com.stdev.AgileWay.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stdev.AgileWay.exceptions.AlreadyExistException;
import com.stdev.AgileWay.exceptions.NotFoundException;
import com.stdev.AgileWay.models.requests.TaskRequest;
import com.stdev.AgileWay.models.responses.TaskResponse;
import com.stdev.AgileWay.services.TaskService;

@Service
public class TaskServiceImpl implements TaskService {

	@Override
	public TaskResponse add(TaskRequest taskRequest) throws AlreadyExistException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TaskResponse> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TaskResponse get(Long id) throws NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) throws NotFoundException {
		// TODO Auto-generated method stub

	}

	@Override
	public TaskResponse update(Long id, TaskRequest taskRequest) throws NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}

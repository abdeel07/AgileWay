package com.stdev.AgileWay.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stdev.AgileWay.entities.SubTask;
import com.stdev.AgileWay.exceptions.AlreadyExistException;
import com.stdev.AgileWay.exceptions.NotFoundException;
import com.stdev.AgileWay.mappers.SubTaskMapper;
import com.stdev.AgileWay.models.requests.SubTaskRequest;
import com.stdev.AgileWay.models.responses.SubTaskResponse;
import com.stdev.AgileWay.repositories.SubTaskRepository;
import com.stdev.AgileWay.services.SubTaskService;

@Service
public class SubTaskServiceImpl implements SubTaskService {

	@Autowired
	SubTaskRepository repository;
	
	@Override
	public SubTaskResponse add(SubTaskRequest subTaskRequest) throws AlreadyExistException {
		SubTask subTask = SubTaskMapper.INSTANCE.subTaskRequestToSubTask(subTaskRequest);
		
		return SubTaskMapper.INSTANCE.subTaskToSubTaskResponse(repository.save(subTask));
	}

	@Override
	public List<SubTaskResponse> getAll() {
		
		return SubTaskMapper.INSTANCE.mapSubTask(repository.findAll());
	}

	@Override
	public SubTaskResponse get(Long id) throws NotFoundException {
		Optional<SubTask> subTask = repository.findById(id);
		
		if(subTask.isEmpty()) {
			throw new NotFoundException(SubTask.class.getSimpleName());
		}
		
		return SubTaskMapper.INSTANCE.subTaskToSubTaskResponse(subTask.get());
	}

	@Override
	public void delete(Long id) throws NotFoundException {
		Optional<SubTask> subTask = repository.findById(id);
		
		if(subTask.isEmpty()) {
			throw new NotFoundException(SubTask.class.getSimpleName());
		}
		
		repository.deleteById(id);

	}

	@Override
	public SubTaskResponse update(Long id, SubTaskRequest subTaskRequest) throws NotFoundException {
		Optional<SubTask> subTask = repository.findById(id);
		
		if(subTask.isEmpty()) {
			throw new NotFoundException(SubTask.class.getSimpleName());
		}
		
		subTask.get().setStatus(subTaskRequest.getStatus());
		subTask.get().setTitle(subTaskRequest.getTitle());
		
		return SubTaskMapper.INSTANCE.subTaskToSubTaskResponse(repository.save(subTask.get()));
	}

}

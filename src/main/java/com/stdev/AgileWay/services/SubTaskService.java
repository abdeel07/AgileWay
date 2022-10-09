package com.stdev.AgileWay.services;

import java.util.List;

import com.stdev.AgileWay.exceptions.AlreadyExistException;
import com.stdev.AgileWay.exceptions.NotFoundException;
import com.stdev.AgileWay.models.requests.SubTaskRequest;
import com.stdev.AgileWay.models.responses.SubTaskResponse;

public interface SubTaskService {
	
	SubTaskResponse add(SubTaskRequest subTaskRequest) throws AlreadyExistException;
	
	List<SubTaskResponse> getAll();
	
	SubTaskResponse get(Long id) throws NotFoundException;
	
	void delete(Long id) throws NotFoundException;
	
	SubTaskResponse update(Long id, SubTaskRequest subTaskRequest) throws NotFoundException;
}

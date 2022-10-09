package com.stdev.AgileWay.services.impl;

import java.util.List;

import com.stdev.AgileWay.exceptions.AlreadyExistException;
import com.stdev.AgileWay.exceptions.NotFoundException;
import com.stdev.AgileWay.models.requests.SubTaskRequest;
import com.stdev.AgileWay.models.responses.SubTaskResponse;
import com.stdev.AgileWay.services.SubTaskService;

public class SubTaskServiceImpl implements SubTaskService {

	@Override
	public SubTaskResponse add(SubTaskRequest subTaskRequest) throws AlreadyExistException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SubTaskResponse> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SubTaskResponse get(Long id) throws NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) throws NotFoundException {
		// TODO Auto-generated method stub

	}

	@Override
	public SubTaskResponse update(Long id, SubTaskRequest subTaskRequest) throws NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}

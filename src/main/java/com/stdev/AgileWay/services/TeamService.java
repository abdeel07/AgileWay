package com.stdev.AgileWay.services;

import java.util.List;

import com.stdev.AgileWay.exceptions.AlreadyExistException;
import com.stdev.AgileWay.exceptions.NotFoundException;
import com.stdev.AgileWay.models.requests.TeamRequest;
import com.stdev.AgileWay.models.responses.TeamResponse;

public interface TeamService {

	TeamResponse add(TeamRequest teamRequest) throws AlreadyExistException;
	
	List<TeamResponse> getAll();
	
	TeamResponse get(Long id) throws NotFoundException;
	
	void delete(Long id) throws NotFoundException;
	
	TeamResponse update(Long id, TeamRequest teamRequest) throws NotFoundException;
}

package com.stdev.AgileWay.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stdev.AgileWay.entities.Team;
import com.stdev.AgileWay.exceptions.AlreadyExistException;
import com.stdev.AgileWay.exceptions.NotFoundException;
import com.stdev.AgileWay.mappers.TeamMapper;
import com.stdev.AgileWay.models.requests.TeamRequest;
import com.stdev.AgileWay.models.responses.TeamResponse;
import com.stdev.AgileWay.repositories.TeamRepository;
import com.stdev.AgileWay.services.TeamService;

@Service
public class TeamServiceImpl implements TeamService {

	@Autowired
	TeamRepository teamRepository;
	
	@Override
	public TeamResponse add(TeamRequest teamRequest) throws AlreadyExistException {
		Optional<Team> findTeam = teamRepository.findByTeamNameContainingIgnoreCase(
				teamRequest.getTeamName());
		if (findTeam.isPresent()) {
			throw new AlreadyExistException(Team.class.getSimpleName());
		}
		
		Team team = TeamMapper.INSTANCE.teamRequestToTeam(teamRequest);
		
		return TeamMapper.INSTANCE.teamToTeamResponse(teamRepository.save(team));
	}

	@Override
	public List<TeamResponse> getAll() {
		return TeamMapper.INSTANCE.mapTeam(teamRepository.findAll());
	}

	@Override
	public TeamResponse get(Long id) throws NotFoundException {
		Optional<Team> findTeam = teamRepository.findById(id);
		if (findTeam.isEmpty()) {
			throw new NotFoundException(Team.class.getSimpleName());
		}
		
		return TeamMapper.INSTANCE.teamToTeamResponse(findTeam.get());
	}

	@Override
	public void delete(Long id) throws NotFoundException {
		Optional<Team> findTeam = teamRepository.findById(id);
		if (findTeam.isEmpty()) {
			throw new NotFoundException(Team.class.getSimpleName());
		}
		
		teamRepository.deleteById(id);
	}

	@Override
	public TeamResponse update(Long id, TeamRequest teamRequest) throws NotFoundException {
		Optional<Team> findTeam = teamRepository.findById(id);
		if (findTeam.isEmpty()) {
			throw new NotFoundException(Team.class.getSimpleName());
		}
		
		findTeam.get().setDescription(teamRequest.getDescription());
		findTeam.get().setTeamName(teamRequest.getTeamName());
		
		return TeamMapper.INSTANCE.teamToTeamResponse(teamRepository.save(findTeam.get()));
	}

}

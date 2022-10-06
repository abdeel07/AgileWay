package com.stdev.AgileWay.mappers;

import java.util.List;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.stdev.AgileWay.entities.Team;
import com.stdev.AgileWay.models.requests.TeamRequest;
import com.stdev.AgileWay.models.responses.TeamResponse;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TeamMapper {

	TeamMapper INSTANCE = Mappers.getMapper(TeamMapper.class);
	
	Team teamRequestToTeam(TeamRequest teamRequest);
	
	TeamResponse teamToTeamResponse(Team team);
	
	List<TeamResponse> mapTeam(List<Team> teams);
}

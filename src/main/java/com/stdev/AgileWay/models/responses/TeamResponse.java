package com.stdev.AgileWay.models.responses;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeamResponse {

	private Long id;
	
	private String teamName;
	
	private String description;
	
	private Set<EmployeeResponse> employees;
	
	private Set<TaskResponse> tasks;
}

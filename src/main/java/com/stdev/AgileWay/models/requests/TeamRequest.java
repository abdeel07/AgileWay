package com.stdev.AgileWay.models.requests;

import javax.persistence.Column;
import javax.validation.constraints.Size;

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
public class TeamRequest {

	@Size(min = 2, max = 30)
	@Column(nullable = false, unique=true)
	private String teamName;
	
	@Size(min = 2, max = 300)
	@Column(nullable = false)
	private String description;
}

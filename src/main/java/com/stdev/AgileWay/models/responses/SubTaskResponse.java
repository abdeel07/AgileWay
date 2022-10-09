package com.stdev.AgileWay.models.responses;

import com.stdev.AgileWay.entities.enums.EStatus;

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
public class SubTaskResponse {

	private Long id;
	
	public String title;
	
	private EStatus status;
}

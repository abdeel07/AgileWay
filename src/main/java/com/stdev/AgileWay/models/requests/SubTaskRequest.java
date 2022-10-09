package com.stdev.AgileWay.models.requests;

import javax.persistence.Column;
import javax.validation.constraints.Size;

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
public class SubTaskRequest {

	@Size(min = 2, max = 70)
	@Column(nullable = false)
	public String title;
	
	@Column(nullable = false)
	private EStatus status;
}

package com.stdev.AgileWay.models.requests;

import java.util.Date;

import javax.persistence.Column;
import javax.validation.constraints.Size;

import com.stdev.AgileWay.entities.enums.ELabel;
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
public class TaskRequest {

	@Size(min = 2, max = 70)
	@Column(nullable = false)
	private String title;
	
	@Size(min = 2, max = 500)
	@Column(nullable = false)
	private String description;
	
	@Column(nullable = false)
	private Date creationDate;
	
	@Column(nullable = false)
	private Date startDate;
	
	private Date endDate;
	
	@Column(nullable = false)
	private ELabel label;
	
	@Column(nullable = false)
	private EStatus status;
	
	@Column(nullable = false)
	private Long teamId;
	
	@Column(nullable = false)
	private Long employeeId;
}

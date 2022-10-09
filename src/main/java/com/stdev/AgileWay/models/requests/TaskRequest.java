package com.stdev.AgileWay.models.requests;

import java.util.Date;

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

	private String title;
	
	private String description;
	
	private Date creationDate;
	
	private Date startDate;
	
	private Date endDate;
	
	private ELabel label;
	
	private EStatus status;
}

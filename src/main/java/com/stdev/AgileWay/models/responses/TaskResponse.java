package com.stdev.AgileWay.models.responses;

import java.util.Date;
import java.util.Set;

import com.stdev.AgileWay.entities.Document;
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
public class TaskResponse {

	private Long id;
	
	private String title;
	
	private String description;
	
	private Date creationDate;
	
	private Date startDate;
	
	private Date endDate;
	
	private ELabel label;
	
	private EStatus status;
	
	private Set<EventResponse> events;
	
	private Set<Document> documents;
	
	private Set<SubTaskResponse> subTasks;
}

package com.stdev.AgileWay.models.requests;

import java.util.Date;

import javax.persistence.Column;

import com.stdev.AgileWay.entities.enums.EType;

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
public class EventRequest {
	
	@Column(nullable = false)
	private EType type;
	
	@Column(nullable = false)
	private Date date;
	
	@Column(nullable = false)
	private Long employeeId;
	
	@Column(nullable = false)
	private Long taskId;
}

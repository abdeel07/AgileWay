package com.stdev.AgileWay.models.requests;

import java.util.Date;

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
	
	private EType type;
	
	private Date date;
	
	private Long employeeId;
}

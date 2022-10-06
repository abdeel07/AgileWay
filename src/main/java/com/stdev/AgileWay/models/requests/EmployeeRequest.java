package com.stdev.AgileWay.models.requests;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
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
public class EmployeeRequest {

	@Size(min = 2, max = 30)
	@Column(nullable = false)
	private String firstName;
	
	@Size(min = 2, max = 30)
	@Column(nullable = false)
	private String lastName;
	
	@Size(min = 7, max = 150)
	@Column(nullable = false, unique=true)
	private String email;
	
	@Size(min = 10, max = 12)
	@Column(nullable = false)
	private String phoneNumber;
	
	@NotNull()
	private Long teamId;
}

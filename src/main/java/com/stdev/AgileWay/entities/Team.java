package com.stdev.AgileWay.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(min = 2, max = 30)
	@Column(nullable = false, unique=true)
	private String teamName;
	
	@Size(min = 2, max = 300)
	@Column(nullable = false)
	private String description;
	
	@JsonManagedReference(value="team-employee")
	@OneToMany(mappedBy = "team")
	private Set<Employee> employees;
}

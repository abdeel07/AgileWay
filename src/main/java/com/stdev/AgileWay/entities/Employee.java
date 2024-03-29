package com.stdev.AgileWay.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
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
	
	@ManyToOne
	@JoinColumn(name = "team_id", nullable = false)
	@JsonBackReference(value="team-employee")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Team team;
	
	@JsonManagedReference(value="employee-event")
	@OneToMany(mappedBy = "employee")
	private Set<Event> events;
}

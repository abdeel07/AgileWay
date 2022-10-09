package com.stdev.AgileWay.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.stdev.AgileWay.entities.enums.EType;

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
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private EType type;
	
	private Date date;
	
	@ManyToOne
	@JoinColumn(name = "employee_id", nullable = false)
	@JsonBackReference(value="employee-event")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Employee employee;
	
	@ManyToOne
	@JoinColumn(name = "task_id", nullable = false)
	@JsonBackReference(value="task-event")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Task task;
}

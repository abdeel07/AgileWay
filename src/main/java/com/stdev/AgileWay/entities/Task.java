package com.stdev.AgileWay.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.stdev.AgileWay.entities.enums.ELabel;
import com.stdev.AgileWay.entities.enums.EStatus;

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
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	
	private String description;
	
	private Date creationDate;
	
	private Date startDate;
	
	private Date endDate;
	
	@Enumerated(EnumType.STRING)
	private ELabel label;
	
	@Enumerated(EnumType.STRING)
	private EStatus status;
	
	@ManyToOne
	@JoinColumn(name = "team_id", nullable = false)
	@JsonBackReference(value="team-task")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Team team;
	
	@JsonManagedReference(value="task-event")
	@OneToMany(mappedBy = "task")
	private Set<Event> events;
	
	@OneToMany(mappedBy = "task", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonManagedReference(value = "task-document")
	private Set<Document> documents;
	
	@JsonManagedReference(value="sub-task")
	@OneToMany(mappedBy = "task")
	private Set<SubTask> subTasks;
}

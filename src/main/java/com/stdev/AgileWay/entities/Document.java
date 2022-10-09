package com.stdev.AgileWay.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
public class Document {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String fileName;

	private String fileType;

	private String path;

	private Date uploadDate;
	
	@ManyToOne
	@JoinColumn(name = "task_id", nullable = false)
	@JsonBackReference(value = "task-document")
	private Task task;
	
	@PrePersist
	private void onCreate() {
		this.uploadDate = new Date();
	}
}

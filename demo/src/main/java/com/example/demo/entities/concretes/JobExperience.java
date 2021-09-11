package com.example.demo.entities.concretes;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Service
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor


@Table(name="job_experience")

@JsonIgnoreProperties({"hibernateLazyInitializer","handler","cv"})

public class JobExperience  {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="job_experience_id")
	private int jobExperienceId;
	@NotNull
	@NotEmpty
	@NotBlank
	@Column(name="workplace_names")
	private String workplaceNames;
	@NotNull
	@NotEmpty
	@NotBlank
	@Column(name="positions")
	private String positions;
	@NotNull
	@NotEmpty
	@NotBlank
	@Column(name="start_date_jobs")
	private Date startDateJobs;


	@Column(name="finish_date_jobs")
	private Date finishDateJobs;

@Column(name="status")
private String status;
	@ManyToOne()
	@JoinColumn(name="foreign_job_experience_id")
	private Cv cv;
	
	
}

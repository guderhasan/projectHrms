package com.example.demo.entities.concretes;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Service;

import com.example.demo.entities.abstracts.IEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name="cv")

@JsonIgnoreProperties({"hibernateLazyInitializer","handler","employee"})

public class Cv implements IEntity{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cv_id")
	private int cv_id;
	
	@Column(name="foreign_school_id")
	private int foreignSchoolId;
	
	@Column(name="foreign_job_experience_id")
	private int foreignJobExperienceId;
	
	
	@Column(name="foreign_foreign_language_id")
	private int foreignForeignLanguageId;
	
	
	
	@NotNull
	@NotEmpty
	@NotBlank
	@Column(name="photo_links")
	private String photoLinks;
	
	@NotNull
	@NotEmpty
	@NotBlank
	@Column(name="github_links")
	private String githubLinks;
	@NotNull
	@NotEmpty
	@NotBlank

	@Column(name="linkedin_links")
	private String linkedinLinks;
	@NotNull
	@NotEmpty
	@NotBlank
	@Column(name="details")
	private String details;
	@NotNull
	@NotEmpty
	@NotBlank
	@Column(name="competences")
	private String competences;


	
	@OneToMany(mappedBy="cv")
	private List<School> school;
 

	@OneToMany(mappedBy="cv")
	private List<ForeignLanguage> foreignLanguages;
	
    
	@OneToMany(mappedBy="cv")
	private List<JobExperience> jobExperience;
    @ManyToOne()
    @JoinColumn(name="foreign_cv_id")
    private Employee employee;
}

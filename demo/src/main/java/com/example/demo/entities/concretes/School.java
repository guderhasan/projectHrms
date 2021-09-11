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
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Service;

import com.example.demo.entities.abstracts.IEntity;
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
@Table(name="school")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","cv"})

public class School {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	@Column(name="school_id")
	private int id;
	@NotNull
	@NotEmpty
	@NotBlank
@Column(name="school_names")
private String schollNames;
	@NotNull
	@NotEmpty
	@NotBlank
@Column(name="departments")
private String departments; 
	@NotNull
	@NotEmpty
	@NotBlank
@Column(name="start_dates")
private Date startDates;
	@NotNull
	@NotEmpty
	@NotBlank
@Column(name="status")
private String status;
	
@Column(name="finish_dates")
private Date finishDates; 
@ManyToOne()
@JoinColumn(name="foreign_school_id")
private Cv cv;

}

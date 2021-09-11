package com.example.demo.entities.concretes;

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
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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

@Table(name="foreign_language")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","cv"})

public class ForeignLanguage   {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	@Column(name="foreign_language_id")
	private int foreignLanguageId;
@NotNull
@NotEmpty
@NotBlank
@Column(name="language_names")
private String languageNames;
@NotNull
@NotEmpty
@NotBlank
@Min(0)
@Max(5)
@Column(name="language_levels")
private int languageLevels;
@ManyToOne()
@JoinColumn(name="foreign_foreign_language_id")
private Cv cv;
}

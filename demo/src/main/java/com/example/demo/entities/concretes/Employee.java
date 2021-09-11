package com.example.demo.entities.concretes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.springframework.stereotype.Indexed;

import com.example.demo.entities.abstracts.IEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@Table(name="employees") 
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name="id")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","cv"})

public class Employee extends Users{

@Column(name="foreign_cv_id")
private int foreignCvId;
 
@Column(name="first_name")
private String firstName;

@Column(name="last_name")
private String lastName;

@Column(name="identity_number")
private String identityNumber;

@Column(name="birth_year")
private int birthYear;

private String password2;



@OneToMany(mappedBy="employee")
private List<Cv> cv;
}

package com.example.demo.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.springframework.stereotype.Indexed;

import com.example.demo.entities.abstracts.IEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@Table(name="employees")
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name="id")
public class Employee extends Users{


@Column(name="id")
private int id;

@Column(name="first_name")
private String firstName;

@Column(name="last_name")
private String lastName;

@Column(name="identity_number")
private String identityNumber;

@Column(name="birth_year")
private int birthYear;

private String password2;


public Employee(String email,String password,String password2,String first_name,String last_Name,String identity_number,int birth_year) {

	setEmail(email);
	setPassword(password);
	this.firstName=first_name;
	this.lastName=last_Name;
	this.identityNumber=identity_number;
	this.birthYear=birth_year;
	this.password2=password2;

}

}

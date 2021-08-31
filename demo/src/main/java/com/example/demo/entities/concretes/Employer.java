package com.example.demo.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.example.demo.entities.abstracts.IEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@Table(name="employers")
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name="id")
public class Employer extends Users{
	

	@Column(name="id")
private int id;
	@Column(name="company_name")
private String company_name;
	@Column(name="we_adress")
private String we_adress;
	@Column(name="phone_number")
private String phone_number;
	private String password2;
	public Employer(String email,String password,String password2,String company_name,String we_adress,String phone_number) {
		setEmail(email);
		setPassword(password);
		this.company_name=company_name;
		this.we_adress=we_adress;
		this.phone_number=phone_number;
		this.password2=password2;
	}
	
	
}

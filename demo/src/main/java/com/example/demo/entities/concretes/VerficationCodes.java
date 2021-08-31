package com.example.demo.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="verification_codes")
@AllArgsConstructor
@NoArgsConstructor
public class VerficationCodes{
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="code")
	private String code;
	
	@Column(name="is_verified")
	private Boolean is_verified;
	
	@Column(name="verified_date")
	private Date verified_date ;

}

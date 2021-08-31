package com.example.demo.entities.concretes;


import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.demo.entities.abstracts.IEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@Table(name="users")
@AllArgsConstructor
@NoArgsConstructor
public class Users implements IEntity{
	@Id
	@GeneratedValue
	@Column(name="id")
private int id;
	@Column(name="email")
private String email;
	@Column(name="password")
private String password;
}

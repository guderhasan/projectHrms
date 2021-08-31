package com.example.demo.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="employee_confirms")
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeConfirms {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="employee_id")
private int employee_id;
	@Column(name="is_confirmed")
	private Boolean is_confirmed;
	@Column(name="confirm_date")
	private Date confirm_date;
}

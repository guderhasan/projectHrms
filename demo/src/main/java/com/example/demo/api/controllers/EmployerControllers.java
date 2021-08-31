package com.example.demo.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.business.abstracts.EmployeeService;
import com.example.demo.business.abstracts.EmployerService;
import com.example.demo.core.concretes.utilities.result.DataResult;
import com.example.demo.core.concretes.utilities.result.Result;
import com.example.demo.entities.concretes.Employee;
import com.example.demo.entities.concretes.Employer;
import com.example.demo.entities.concretes.Users;

@RestController
@RequestMapping("/api/employers")
public class EmployerControllers {
	private EmployerService employerService;

	
	@Autowired
	public EmployerControllers(EmployerService employerService) {
		super();
		this.employerService = employerService;
	}



	@GetMapping("/getallemployers")
	public DataResult<List<Users>> getAllEmployers(){
		return this.employerService.getAll();
	}
	
	@PostMapping("/setemployers")
	public Result setUsers(@RequestBody Employer employer){
		return employerService.sign(employer);
		
	}}
package com.example.demo.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.business.abstracts.EmployeeConfirmService;
import com.example.demo.business.abstracts.SystemEmployeeService;
import com.example.demo.core.concretes.utilities.result.Result;
import com.example.demo.entities.concretes.EmployeeConfirms;
import com.example.demo.entities.concretes.Employer;
import com.example.demo.entities.concretes.SystemEmployee;
@RestController
@RequestMapping("/api/systememployee")
public class SystemEmployeeControllers {
private SystemEmployeeService  systemEmployeeService;
	
	
	
	@Autowired
public SystemEmployeeControllers(SystemEmployeeService systemEmployeeService) {
		super();
		this.systemEmployeeService = systemEmployeeService;
	}


	@PostMapping("/setConfirms")
	public Result setConfirms(@RequestBody EmployeeConfirms employeeConfirms){
		return systemEmployeeService.setConfirm(employeeConfirms);	
	}


}

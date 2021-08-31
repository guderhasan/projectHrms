package com.example.demo.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.business.abstracts.EmployeeConfirmService;
import com.example.demo.core.concretes.utilities.result.DataResult;
import com.example.demo.entities.concretes.EmployeeConfirms;
import com.example.demo.entities.concretes.Users;

@RestController
@RequestMapping("/api/confirms")
public class EmployeeConfirmControllers {
	private EmployeeConfirmService  employeeConfirmService;
	
	
	
	@Autowired
public EmployeeConfirmControllers(EmployeeConfirmService employeeConfirmService) {
		super();
		this.employeeConfirmService = employeeConfirmService;
	}




@GetMapping("/getallconfirms")
public DataResult<List<EmployeeConfirms>> getAllConfirms(){
	return this.employeeConfirmService.getAll();
}


}

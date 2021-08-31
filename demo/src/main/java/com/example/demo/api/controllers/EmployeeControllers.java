package com.example.demo.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.business.abstracts.EmployeeService;
import com.example.demo.business.abstracts.UsersService;
import com.example.demo.core.concretes.utilities.result.DataResult;
import com.example.demo.core.concretes.utilities.result.Result;
import com.example.demo.entities.concretes.Employee;
import com.example.demo.entities.concretes.Users;


@RestController
@RequestMapping("/api/employees")
public class EmployeeControllers {
	private EmployeeService employeeService;

	
	@Autowired
	public EmployeeControllers(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}



	@GetMapping("/getallemployees")
	public DataResult<List<Users>> getAllEmployees(){
		return this.employeeService.getAll();
	}
	
	@PostMapping("/setemployees")
	public Result setUsers(@RequestBody Employee employee){
		return employeeService.sign(employee);
		
	}
	
}



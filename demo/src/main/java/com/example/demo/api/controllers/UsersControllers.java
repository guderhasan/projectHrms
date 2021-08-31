package com.example.demo.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.business.abstracts.UsersService;
import com.example.demo.business.concretes.EmployeeManager;
import com.example.demo.business.concretes.UsersManager;
import com.example.demo.core.concretes.utilities.result.DataResult;
import com.example.demo.core.concretes.utilities.result.Result;
import com.example.demo.entities.concretes.Employee;
import com.example.demo.entities.concretes.EmployeeConfirms;
import com.example.demo.entities.concretes.Users;

@RestController
@RequestMapping("/api/users")
public class UsersControllers {
	private UsersService usersService;

	
	@Autowired
	public UsersControllers(UsersService usersService) {
		super();
		this.usersService = usersService;
	}



	@GetMapping("/getallusers")
	public DataResult<List<Users>> getAllUsers(){
		return this.usersService.getAll();
	}
	
	
	
}

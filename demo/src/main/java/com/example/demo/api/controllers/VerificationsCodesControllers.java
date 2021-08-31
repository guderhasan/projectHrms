package com.example.demo.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.business.abstracts.VerificationsCodesService;
import com.example.demo.core.concretes.utilities.result.DataResult;
import com.example.demo.core.concretes.utilities.result.Result;
import com.example.demo.entities.concretes.Employee;
import com.example.demo.entities.concretes.EmployeeConfirms;
import com.example.demo.entities.concretes.Users;
import com.example.demo.entities.concretes.VerficationCodes;

@RestController
@RequestMapping("/api/codes")
public class VerificationsCodesControllers {
	
	private VerificationsCodesService  verificationsCodesService;
	
	@Autowired
	public VerificationsCodesControllers(VerificationsCodesService verificationsCodesService) {
		super();
		this.verificationsCodesService = verificationsCodesService;
	}


	@GetMapping("/getallcodes")
	public DataResult<List<VerficationCodes>> getAllCodes(){
		return this.verificationsCodesService.getAll();
	}
	
	
	@PostMapping("/setcodes")
	public Result setCodes(@RequestBody VerficationCodes verficationCodes){
		return verificationsCodesService.sendMail(verficationCodes);
		
	}
	
	
}

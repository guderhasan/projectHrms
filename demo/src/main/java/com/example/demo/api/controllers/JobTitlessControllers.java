package com.example.demo.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.business.abstracts.JobTitlesService;
import com.example.demo.core.concretes.utilities.result.DataResult;
import com.example.demo.core.concretes.utilities.result.Result;
import com.example.demo.entities.concretes.Employee;
import com.example.demo.entities.concretes.EmployeeConfirms;
import com.example.demo.entities.concretes.JobTitles;

@RestController
@RequestMapping("/api/titless")
public class JobTitlessControllers {
	
private JobTitlesService jobTitlesService;
	
	
	
	@Autowired
	public JobTitlessControllers(JobTitlesService jobTitlesService) {
	super();
	this.jobTitlesService = jobTitlesService;
}
	
	@GetMapping("/getalltitless")
	public DataResult<List<JobTitles>> getAllTitless(){
		return this.jobTitlesService.getAll();
	}
	@PostMapping("/settitless")
	public Result setTitless(@RequestBody JobTitles jobTitless){
		return jobTitlesService.setJobTitless(jobTitless);
	}
}

package com.example.demo.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.business.abstracts.SystemEmployeeJobPositionService;
import com.example.demo.core.concretes.utilities.result.DataResult;
import com.example.demo.core.concretes.utilities.result.Result;
import com.example.demo.entities.concretes.JobTitles;
import com.example.demo.entities.concretes.SystemEmployeeJobPosition;

@RestController
@RequestMapping("/api/positions")
public class SystemEmployeeJobPositionControllers {
private SystemEmployeeJobPositionService systemEmployeeJobPositionService;
@Autowired
public SystemEmployeeJobPositionControllers(SystemEmployeeJobPositionService systemEmployeeJobPositionService) {
	super();
	this.systemEmployeeJobPositionService = systemEmployeeJobPositionService;
}


@GetMapping("/getallpositions")
public DataResult<List<SystemEmployeeJobPosition>> getAllPositions(){
	return this.systemEmployeeJobPositionService.getAll();
}
@PostMapping("/setpositions")
public Result setPositions(@RequestBody SystemEmployeeJobPosition systemEmployeeJobPosition){
	return systemEmployeeJobPositionService.setJobPositions(systemEmployeeJobPosition);
}
}

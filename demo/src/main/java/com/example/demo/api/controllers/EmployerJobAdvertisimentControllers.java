package com.example.demo.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.business.abstracts.EmployerJobAdvertisimentService;
import com.example.demo.core.concretes.utilities.result.DataResult;
import com.example.demo.core.concretes.utilities.result.Result;
import com.example.demo.entities.concretes.City;
import com.example.demo.entities.concretes.EmployerJobAdvertisiment;

@RestController
@RequestMapping("/api/advertisiments")
public class EmployerJobAdvertisimentControllers {

	private EmployerJobAdvertisimentService employerJobAdvertisimentService;
@Autowired
	public EmployerJobAdvertisimentControllers(EmployerJobAdvertisimentService employerJobAdvertisimentService) {
		super();
		this.employerJobAdvertisimentService = employerJobAdvertisimentService;
	}
@GetMapping("/getalladvertisiments")
public DataResult<List<EmployerJobAdvertisiment>> getAllAdvertisiments(){
	return this.employerJobAdvertisimentService.getAll();
}
@PostMapping("/setadvertisiments")
public Result setadvertisiments(@RequestBody EmployerJobAdvertisiment employerJobAdvertisiment){
	return employerJobAdvertisimentService.setAdvertisiment(employerJobAdvertisiment);
}

@GetMapping("/getByIsActive")
public DataResult<List<EmployerJobAdvertisiment>> getByIsActive(@RequestParam boolean is_active){
	return this.employerJobAdvertisimentService.getByIsActive(is_active);
}
@GetMapping("/getByDateExplainsAndIsActive")
public DataResult<List<EmployerJobAdvertisiment>> getByDateExplainsAndIsActive(@RequestParam String dateExplains,@RequestParam boolean isActive){
	return this.employerJobAdvertisimentService.getByDateExplainsAndIsActive(dateExplains,isActive);
}
@GetMapping("/getByIdAndIsActiveToDeActive")
public Result getByIdAndIsActiveToDeActive(@RequestParam int id,@RequestParam boolean isActive){
	return this.employerJobAdvertisimentService.getByIdAndIsActiveToDeActive(id,isActive);
}
@GetMapping("/getByIEmployerIdAndIsActive")
public DataResult<List<EmployerJobAdvertisiment>> getByIEmployerIdAndIsActive(@RequestParam int id,@RequestParam boolean isActive){
	return this.employerJobAdvertisimentService.getByEmployerIdAndIsActive(id,isActive);
}
}

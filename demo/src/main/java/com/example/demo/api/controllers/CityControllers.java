package com.example.demo.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.business.abstracts.CityService;
import com.example.demo.business.abstracts.SystemEmployeeJobPositionService;
import com.example.demo.core.concretes.utilities.result.DataResult;
import com.example.demo.core.concretes.utilities.result.Result;
import com.example.demo.entities.concretes.City;
import com.example.demo.entities.concretes.SystemEmployeeJobPosition;

@RestController
@RequestMapping("/api/cities")
public class CityControllers {
	private CityService cityService;
	@Autowired
	public CityControllers(CityService cityService) {
		super();
		this.cityService = cityService;
	}


	@GetMapping("/getallcities")
	public DataResult<List<City>> getAllCities(){
		return this.cityService.getAll();
	}
	@PostMapping("/setcities")
	public Result setCities(@RequestBody City city){
		return cityService.setCities(city);
	}
}

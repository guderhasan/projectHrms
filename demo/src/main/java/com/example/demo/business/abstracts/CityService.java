package com.example.demo.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.core.concretes.utilities.result.DataResult;
import com.example.demo.core.concretes.utilities.result.Result;
import com.example.demo.entities.concretes.City;
import com.example.demo.entities.concretes.SystemEmployeeJobPosition;

public interface CityService {
	Result setCities(City city);
	DataResult<List<City>> getAll();
	public  String getCities();
}

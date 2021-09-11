package com.example.demo.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.business.abstracts.CityService;
import com.example.demo.business.abstracts.SchoolService;
import com.example.demo.core.concretes.utilities.result.DataResult;
import com.example.demo.core.concretes.utilities.result.ErrorDataResult;
import com.example.demo.core.concretes.utilities.result.Result;
import com.example.demo.entities.concretes.City;
import com.example.demo.entities.concretes.School;

@RestController
@RequestMapping("/api/schools")
public class SchoolController {
	private SchoolService schoolService;
	@Autowired
	public SchoolController(SchoolService schoolService) {
		super();
		this.schoolService = schoolService;
	}



	@PostMapping("/setschools")
	public ResponseEntity<?>  setschools(@Valid @RequestBody School school){
		return ResponseEntity.ok(schoolService.setSchool(school));
	}
	@GetMapping("/getemployeesschools")
	public DataResult<List<School>> getemployeesschools(int foreignSchoolId){
		return this.schoolService.getEmployeesSchools(foreignSchoolId);
	}

@ExceptionHandler(MethodArgumentNotValidException.class)
@ResponseStatus(HttpStatus.BAD_REQUEST)
public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
	Map<String,String> validationErrors=new HashMap<String,String>();
	for(FieldError fieldError:exceptions.getBindingResult().getFieldErrors()) {
		validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
	}
	ErrorDataResult<Object> errors=new ErrorDataResult<Object>(validationErrors,"Doğrulama Hatası");

	return errors;

}
}

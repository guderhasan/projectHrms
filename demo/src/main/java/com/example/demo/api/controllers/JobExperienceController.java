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

import com.example.demo.business.abstracts.JobExperienceService;
import com.example.demo.core.concretes.utilities.result.DataResult;
import com.example.demo.core.concretes.utilities.result.ErrorDataResult;
import com.example.demo.core.concretes.utilities.result.Result;
import com.example.demo.entities.concretes.JobExperience;
import com.example.demo.entities.concretes.School;

@RestController
@RequestMapping("/api/jobs")
public class JobExperienceController {
private JobExperienceService  jobExperienceService;
@Autowired
public JobExperienceController(JobExperienceService jobExperienceService) {
	super();
	this.jobExperienceService = jobExperienceService;
}


@PostMapping("/setjobs")
public ResponseEntity<?>  setjobs(@Valid @RequestBody JobExperience jobExperience){
	return ResponseEntity.ok(jobExperienceService.setJobs(jobExperience));
}
@GetMapping("/getemployeesjobs")
public DataResult<List<JobExperience>> getEmployeesJobs(int foreignJobExperienceId){
	return this.jobExperienceService.getEmployeesJobs(foreignJobExperienceId);
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

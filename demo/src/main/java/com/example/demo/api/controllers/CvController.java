package com.example.demo.api.controllers;


import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.business.abstracts.CvService;
import com.example.demo.core.concretes.utilities.result.DataResult;
import com.example.demo.core.concretes.utilities.result.ErrorDataResult;
import com.example.demo.entities.concretes.City;
import com.example.demo.entities.concretes.Cv;
import com.example.demo.entities.concretes.School;


@RestController
@RequestMapping("/api/cv")
public class CvController {
	
private CvService cvService;
@Autowired
public CvController(CvService cvService) {
	super();
	this.cvService = cvService;
}




@PostMapping(value="/add")
public ResponseEntity<?> add(@Valid @RequestBody Cv cv,@RequestPart MultipartFile multipartFile) throws IOException{
	return ResponseEntity.ok(this.cvService.setCv(cv,multipartFile));



}

@GetMapping("/getemployeescv")
public DataResult<List<Cv>> getEmployeesCv(@RequestParam int foreignCvId){
	return this.cvService.getEmployeesCvs(foreignCvId);
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

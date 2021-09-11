package com.example.demo.api.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.business.abstracts.ForeignLanguageService;
import com.example.demo.core.concretes.utilities.result.ErrorDataResult;
import com.example.demo.core.concretes.utilities.result.Result;
import com.example.demo.dataAccess.abstracts.ForeignLanguageDao;
import com.example.demo.entities.concretes.ForeignLanguage;
import com.example.demo.entities.concretes.JobExperience;

@RestController
@RequestMapping("/api/languages")
public class ForeignLanguageCotroller {
	
	private ForeignLanguageService foreignLanguageService;
	
	@Autowired
	public ForeignLanguageCotroller(ForeignLanguageService foreignLanguageService) {
		super();
		this.foreignLanguageService = foreignLanguageService;
	}


	@PostMapping("/setlanguages")
	public ResponseEntity<?>  setLanguages(@Valid @RequestBody ForeignLanguage foreignLanguage){
		return ResponseEntity.ok(foreignLanguageService.setLanguages(foreignLanguage));
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

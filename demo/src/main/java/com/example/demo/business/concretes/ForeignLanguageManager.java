package com.example.demo.business.concretes;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.business.abstracts.ForeignLanguageService;
import com.example.demo.core.concretes.utilities.result.Result;
import com.example.demo.core.concretes.utilities.result.SuccessResult;
import com.example.demo.dataAccess.abstracts.ForeignLanguageDao;
import com.example.demo.entities.concretes.ForeignLanguage;
@Service
public class ForeignLanguageManager implements ForeignLanguageService{
private ForeignLanguageDao  foreignLanguageDao;
@Autowired
	public ForeignLanguageManager(ForeignLanguageDao foreignLanguageDao) {
	super();
	this.foreignLanguageDao = foreignLanguageDao;
}
	@Override
	public Result setLanguages(ForeignLanguage foreignLanguage) {
		this.foreignLanguageDao.save(foreignLanguage);
		return new SuccessResult("Başarıyla Eklendi");
	}

}

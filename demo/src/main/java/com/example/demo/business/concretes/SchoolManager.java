package com.example.demo.business.concretes;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.business.abstracts.SchoolService;
import com.example.demo.core.concretes.utilities.result.DataResult;
import com.example.demo.core.concretes.utilities.result.Result;
import com.example.demo.core.concretes.utilities.result.SuccessDataResult;
import com.example.demo.core.concretes.utilities.result.SuccessResult;
import com.example.demo.dataAccess.abstracts.SchoolDao;
import com.example.demo.entities.concretes.Cv;
import com.example.demo.entities.concretes.Employee;
import com.example.demo.entities.concretes.School;
@Service
public class SchoolManager implements SchoolService{
	
	
private SchoolDao  schoolDao;

@Autowired
	public SchoolManager(SchoolDao schoolDao) {
	super();
	this.schoolDao = schoolDao;
}
	@Override
	public Result setSchool(School school) {
		this.schoolDao.save(school);
		return new SuccessResult("Başarıyla Eklendi");
	}
	
	@Override
	public DataResult<List<School>> getEmployeesSchools(int foreignSchoolId) {
		// TODO Auto-generated method stub
		
	for(School school:this.schoolDao.getByCv_ForeignSchoolIdOrderByFinishDatesDesc(foreignSchoolId)) {
		if(school.getFinishDates()==null) {
			school.setStatus("Devam Ediyor");
		}
		else {
			school.setStatus("Bitti");

		}
	}
		return new SuccessDataResult<List<School>>(this.schoolDao.getByCv_ForeignSchoolIdOrderByFinishDatesDesc(foreignSchoolId),"Data Listelendi");
	}
	
	
	
	

}

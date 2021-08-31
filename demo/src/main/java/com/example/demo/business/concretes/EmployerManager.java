package com.example.demo.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.business.abstracts.EmployeeService;
import com.example.demo.business.abstracts.EmployerService;
import com.example.demo.business.abstracts.UsersService;
import com.example.demo.core.abstracts.CheckEmployeeService;
import com.example.demo.core.abstracts.CheckEmployerService;
import com.example.demo.core.concretes.utilities.result.DataResult;
import com.example.demo.core.concretes.utilities.result.ErrorResult;
import com.example.demo.core.concretes.utilities.result.Result;
import com.example.demo.core.concretes.utilities.result.SuccessDataResult;
import com.example.demo.core.concretes.utilities.result.SuccessResult;
import com.example.demo.dataAccess.abstracts.EmployeeDao;
import com.example.demo.dataAccess.abstracts.EmployerDao;
import com.example.demo.dataAccess.abstracts.UsersDao;
import com.example.demo.entities.concretes.Employee;
import com.example.demo.entities.concretes.Employer;
import com.example.demo.entities.concretes.Users;

@Service
public class EmployerManager implements EmployerService{
	@Autowired
	private CheckEmployerService checkEmployerService;
	
public EmployerManager(CheckEmployerService checkEmployerService) {
		super();
		this.checkEmployerService = checkEmployerService;
	}
private EmployerDao employerDao;

	

	@Autowired
		public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}
@Autowired
	private UsersDao userDao;
	public EmployerManager(UsersDao userDao) {
		super();
		this.userDao = userDao;
	}
	@Override
	public DataResult<List<Users>> getAll() {
		return new SuccessDataResult<List<Users>>(this.userDao.findAll(),"İşverenler Listelendi");
	}
	@Override
	public Result sign(Employer employer) { 
		Result result;
		if((checkEmployerService.signCheck((employer)))) {
			employerDao.save(employer);
			System.out.println("Kayıt Basarılı");
			result=new SuccessResult("İşveren Eklendi");
			
			
		}
		else {

			System.out.println("Kayıt Başarısız");
			result=new ErrorResult("Kayıt Başarısız");
		}
		return result;
		
	}
	
	
}

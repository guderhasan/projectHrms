package com.example.demo.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.business.abstracts.EmployeeService;
import com.example.demo.business.abstracts.UsersService;
import com.example.demo.business.abstracts.VerificationsCodesService;
import com.example.demo.core.abstracts.CheckEmployeeService;
import com.example.demo.core.abstracts.CheckService;
import com.example.demo.core.abstracts.MernisServiceAdaptorService;
import com.example.demo.core.concretes.utilities.result.DataResult;
import com.example.demo.core.concretes.utilities.result.ErrorResult;
import com.example.demo.core.concretes.utilities.result.Result;
import com.example.demo.core.concretes.utilities.result.SuccessDataResult;
import com.example.demo.core.concretes.utilities.result.SuccessResult;
import com.example.demo.dataAccess.abstracts.EmployeeDao;
import com.example.demo.dataAccess.abstracts.UsersDao;
import com.example.demo.entities.concretes.Employee;
import com.example.demo.entities.concretes.Users;
@Service
public class EmployeeManager implements EmployeeService{
	@Autowired
	private CheckEmployeeService checkEmployeeService;
	
public EmployeeManager(CheckEmployeeService checkEmployeeService) {
		super();
		this.checkEmployeeService = checkEmployeeService;
	}
private EmployeeDao employeeDao;

	

	@Autowired
		public EmployeeManager(EmployeeDao employeeDao) {
		super();
		this.employeeDao = employeeDao;
	}
@Autowired
	private UsersDao userDao;
	public EmployeeManager(UsersDao userDao) {
		super();
		this.userDao = userDao;
	}
	@Override
	public DataResult<List<Users>> getAll() {
		return new SuccessDataResult<List<Users>>(this.userDao.findAll(),"İşçiler Listelendi");
	}
	@Override
	public Result sign(Employee employee) { 
		Result result;
		if((checkEmployeeService.signCheck((employee)))) {
			employeeDao.save(employee);
			System.out.println("Kayıt Basarılı");
			result=new SuccessResult("İşçi Eklendi");
			
			
		}
		else {

			System.out.println("Kayıt Başarısız");
			result=new ErrorResult("Kayıt Başarısız");
		}
		return result;
		
	}
	
}

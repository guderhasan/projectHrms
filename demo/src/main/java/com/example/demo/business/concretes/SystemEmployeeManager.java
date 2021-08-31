package com.example.demo.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.business.abstracts.SystemEmployeeService;
import com.example.demo.business.abstracts.UsersService;
import com.example.demo.core.concretes.utilities.result.DataResult;
import com.example.demo.core.concretes.utilities.result.Result;
import com.example.demo.core.concretes.utilities.result.SuccessResult;
import com.example.demo.dataAccess.abstracts.EmployeeConfirmDao;
import com.example.demo.entities.concretes.Employee;
import com.example.demo.entities.concretes.EmployeeConfirms;
import com.example.demo.entities.concretes.Users;
@Service
public class SystemEmployeeManager implements SystemEmployeeService{

	private EmployeeConfirmDao employeeConfirmDao;
@Autowired
	public SystemEmployeeManager(EmployeeConfirmDao employeeConfirmDao) {
		super();
		this.employeeConfirmDao = employeeConfirmDao;
	}


@Override
public Result setConfirm(EmployeeConfirms employeeConfirms) {
	this.employeeConfirmDao.save(employeeConfirms);
	return new SuccessResult("İşveren Doğrulandı");
}

	
	}



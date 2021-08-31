package com.example.demo.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.business.abstracts.UsersService;
import com.example.demo.core.abstracts.CheckService;
import com.example.demo.core.concretes.utilities.result.DataResult;
import com.example.demo.core.concretes.utilities.result.Result;
import com.example.demo.core.concretes.utilities.result.SuccessDataResult;
import com.example.demo.core.concretes.utilities.result.SuccessResult;
import com.example.demo.dataAccess.abstracts.UsersDao;
import com.example.demo.entities.concretes.Employee;
import com.example.demo.entities.concretes.Users;
@Service
public  class UsersManager implements UsersService{
private UsersDao usersDao;



@Autowired
	public UsersManager(UsersDao usersDao) {
	super();
	this.usersDao = usersDao;
}
public UsersManager() {}
	@Override
	public DataResult<List<Users>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Users>>(this.usersDao.findAll(),"Kullanıcılar Listelendi");
				
				
	}
	
	
	
}

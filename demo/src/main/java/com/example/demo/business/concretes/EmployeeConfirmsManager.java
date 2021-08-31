package com.example.demo.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.business.abstracts.EmployeeConfirmService;
import com.example.demo.core.concretes.utilities.result.DataResult;
import com.example.demo.core.concretes.utilities.result.SuccessDataResult;
import com.example.demo.dataAccess.abstracts.EmployeeConfirmDao;
import com.example.demo.entities.concretes.EmployeeConfirms;
import com.example.demo.entities.concretes.Users;
import com.example.demo.entities.concretes.VerficationCodes;
@Service
public class EmployeeConfirmsManager implements EmployeeConfirmService{
	boolean verifications;
private EmployeeConfirmDao employersConfirmsDao;

@Autowired
	public EmployeeConfirmsManager(EmployeeConfirmDao employersConfirmsDao) {
	super();
	this.employersConfirmsDao = employersConfirmsDao;
}


	@Override
	public DataResult<List<EmployeeConfirms>> getAll() {
		return new SuccessDataResult<List<EmployeeConfirms>>(this.employersConfirmsDao.findAll(),"Onaylananalar  Listelendi");
				
	}


	@Override
	public boolean getConfirms() {
		for(EmployeeConfirms employeeConfirms:this.employersConfirmsDao.findAll()) {
			verifications=employeeConfirms.getIs_confirmed();
		}
		
		return verifications;
	}
	
	
	

}

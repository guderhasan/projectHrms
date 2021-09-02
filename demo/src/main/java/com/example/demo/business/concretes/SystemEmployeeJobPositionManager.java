package com.example.demo.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.business.abstracts.SystemEmployeeJobPositionService;
import com.example.demo.core.concretes.utilities.result.DataResult;
import com.example.demo.core.concretes.utilities.result.Result;
import com.example.demo.core.concretes.utilities.result.SuccessDataResult;
import com.example.demo.core.concretes.utilities.result.SuccessResult;
import com.example.demo.dataAccess.abstracts.SystemEmployeeJobPositionDao;
import com.example.demo.entities.concretes.SystemEmployeeJobPosition;
@Service
public class SystemEmployeeJobPositionManager implements SystemEmployeeJobPositionService{
private SystemEmployeeJobPositionDao systemEmployeeJobPositionDao;
	
@Autowired
public SystemEmployeeJobPositionManager(SystemEmployeeJobPositionDao systemEmployeeJobPositionDao) {
	super();
	this.systemEmployeeJobPositionDao = systemEmployeeJobPositionDao;
}

	@Override
	public Result setJobPositions(SystemEmployeeJobPosition systemEmployeeJobPosition) {
		
		this.systemEmployeeJobPositionDao.save(systemEmployeeJobPosition);
		return new SuccessResult("Ekleme Başarılı");
	}

	@Override
	public DataResult<List<SystemEmployeeJobPosition>> getAll() {
		return new SuccessDataResult<List<SystemEmployeeJobPosition>>(this.systemEmployeeJobPositionDao.findAll(),"İş Pozisyonları Listelendi");
	}

}

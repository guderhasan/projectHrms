package com.example.demo.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.business.abstracts.EmployerJobAdvertisimentService;
import com.example.demo.core.concretes.utilities.result.DataResult;
import com.example.demo.core.concretes.utilities.result.Result;
import com.example.demo.core.concretes.utilities.result.SuccessDataResult;
import com.example.demo.core.concretes.utilities.result.SuccessResult;
import com.example.demo.dataAccess.abstracts.EmployerJobAdvertisimentDao;
import com.example.demo.entities.concretes.City;
import com.example.demo.entities.concretes.EmployerJobAdvertisiment;
@Service
public class EmployerJobAdvertisimentManager implements EmployerJobAdvertisimentService{
String positions;
	




	@Autowired
	private EmployerJobAdvertisimentDao  employerJobAdvertisimentDao;
	
	public EmployerJobAdvertisimentManager(EmployerJobAdvertisimentDao employerJobAdvertisimentDao) {
		super();
		this.employerJobAdvertisimentDao = employerJobAdvertisimentDao;
	}

	@Override
	public Result setAdvertisiment(EmployerJobAdvertisiment employerJobAdvertisiment) {
		this.employerJobAdvertisimentDao.save(employerJobAdvertisiment);
		return new SuccessResult("Ekleme Başarılı");
	}

	@Override
	public DataResult<List<EmployerJobAdvertisiment>> getAll() {
		
		return new SuccessDataResult<List<EmployerJobAdvertisiment>>(this.employerJobAdvertisimentDao.findAll(),"İlanlar Listelendi");

	}

	@Override
	public String getPositions() {
		for(EmployerJobAdvertisiment employerJobAdvertisiment:this.employerJobAdvertisimentDao.findAll()) {
			positions=employerJobAdvertisiment.getJobPositions();
		}
		

		return positions;
	}

	@Override
	public DataResult<List<EmployerJobAdvertisiment>> getByIsActive(boolean isActive) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<EmployerJobAdvertisiment>>(this.employerJobAdvertisimentDao.getByIsActive(isActive));
	}

	@Override
	public DataResult<List<EmployerJobAdvertisiment>> getByDateExplainsAndIsActive(String dateExplains,boolean isActive) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<EmployerJobAdvertisiment>>(this.employerJobAdvertisimentDao.getByDateExplainsAndIsActive(dateExplains,isActive));
	}

	@Override
	public Result getByIdAndIsActiveToDeActive(int id,boolean isActive) {
	
		for(EmployerJobAdvertisiment employerJobAdvertisiment:this.employerJobAdvertisimentDao.getByIdAndIsActive(id, isActive) ) {
			

			employerJobAdvertisiment.setId(id);
			employerJobAdvertisiment.setActive(false);
			this.employerJobAdvertisimentDao.save(employerJobAdvertisiment);
		}
		return new SuccessResult("Güncelleme Başarılı,İlan Pasif Edildi");
		
	}

	@Override
	public DataResult<List<EmployerJobAdvertisiment>> getByEmployerIdAndIsActive(int employerId,boolean isActive) {
		return new SuccessDataResult<List<EmployerJobAdvertisiment>>(this.employerJobAdvertisimentDao.getByEmployerIdAndIsActive(employerId,isActive));

	}

	
	
}

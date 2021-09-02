package com.example.demo.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.business.abstracts.CityService;
import com.example.demo.core.concretes.utilities.result.DataResult;
import com.example.demo.core.concretes.utilities.result.Result;
import com.example.demo.core.concretes.utilities.result.SuccessDataResult;
import com.example.demo.core.concretes.utilities.result.SuccessResult;
import com.example.demo.dataAccess.abstracts.CityDao;
import com.example.demo.dataAccess.abstracts.SystemEmployeeJobPositionDao;
import com.example.demo.entities.concretes.City;
import com.example.demo.entities.concretes.SystemEmployeeJobPosition;
@Service
public class CityManager  implements CityService{
String cities;
	private CityDao cityDao;
	
	@Autowired
	public CityManager(CityDao cityDao) {
		super();
		this.cityDao = cityDao;
	}

		@Override
		public Result setCities(City city) {
			
			this.cityDao.save(city);
			return new SuccessResult("Ekleme Başarılı");
		}

		@Override
		public DataResult<List<City>> getAll() {
			return new SuccessDataResult<List<City>>(this.cityDao.findAll(),"Şehirler Listelendi");
		}

		@Override
		public String getCities() {
			
			for(City city:this.cityDao.findAll()) {
				cities=city.getCities();
			}
			return cities;
		}

}

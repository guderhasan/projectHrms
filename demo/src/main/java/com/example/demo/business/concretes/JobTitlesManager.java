package com.example.demo.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.business.abstracts.JobTitlesService;
import com.example.demo.core.concretes.utilities.result.DataResult;
import com.example.demo.core.concretes.utilities.result.ErrorResult;
import com.example.demo.core.concretes.utilities.result.Result;
import com.example.demo.core.concretes.utilities.result.SuccessDataResult;
import com.example.demo.core.concretes.utilities.result.SuccessResult;
import com.example.demo.dataAccess.abstracts.JobTitlesDao;
import com.example.demo.entities.concretes.JobTitles;
@Service
public class JobTitlesManager implements JobTitlesService{
	private JobTitlesDao jobTitlesDao;
	
	@Autowired
	public JobTitlesManager(JobTitlesDao jobTitlesDao) {
		super();
		this.jobTitlesDao = jobTitlesDao;
	}

	
	@Override
	public DataResult<List<JobTitles>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobTitles>>(this.jobTitlesDao.findAll(),"Meslekler Listelendi");
				

	}


	@Override
	public Result setJobTitless(JobTitles jobTitles) {
		Result result;
		// TODO Auto-generated method stub
		if(!jobTitlesDao.existsByTitle(jobTitles.getTitle())) {
			this.jobTitlesDao.save(jobTitles);
			System.out.println("Kayıt Başarılı");
			result=new SuccessResult("Meslek Eklendi");
		}
		else {
			System.out.println("Kayıt Başarısız,Zaten böyle bir meslek var");
			result=new ErrorResult("Kayıt Başarısız");
		}
		
		return result;
	}

	


}

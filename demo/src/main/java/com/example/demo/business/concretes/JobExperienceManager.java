package com.example.demo.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.business.abstracts.JobExperienceService;
import com.example.demo.core.concretes.utilities.result.DataResult;
import com.example.demo.core.concretes.utilities.result.Result;
import com.example.demo.core.concretes.utilities.result.SuccessDataResult;
import com.example.demo.core.concretes.utilities.result.SuccessResult;
import com.example.demo.dataAccess.abstracts.JobExperienceDao;
import com.example.demo.entities.concretes.JobExperience;
import com.example.demo.entities.concretes.School;
@Service
public class JobExperienceManager implements JobExperienceService{
private JobExperienceDao jobExperienceDao;

@Autowired
	public JobExperienceManager(JobExperienceDao jobExperienceDao) {
	super();
	this.jobExperienceDao = jobExperienceDao;
}


	@Override
	public DataResult<List<JobExperience>> getEmployeesJobs(int foreignJobExperienceId) {
		for(JobExperience jobExperience:this.jobExperienceDao.getByCv_ForeignJobExperienceIdOrderByFinishDateJobsDesc(foreignJobExperienceId)) {
			if(jobExperience.getFinishDateJobs()==null) {
				jobExperience.setStatus("Devam Ediyor");
			}
			else {
				jobExperience.setStatus("Bitti");

			}
		}
			return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.getByCv_ForeignJobExperienceIdOrderByFinishDateJobsDesc(foreignJobExperienceId),"Data Listelendi");
		}


	@Override
	public Result setJobs(JobExperience jobExperience) {
		this.jobExperienceDao.save(jobExperience);
		return new SuccessResult("Başarıyla Eklendi");
	}
	}



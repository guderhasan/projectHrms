package com.example.demo.business.abstracts;

import java.util.List;

import com.example.demo.core.concretes.utilities.result.DataResult;
import com.example.demo.core.concretes.utilities.result.Result;
import com.example.demo.entities.concretes.JobExperience;
import com.example.demo.entities.concretes.School;

public interface JobExperienceService {
	DataResult<List<JobExperience>> getEmployeesJobs(int foreignJobExperienceId);
	Result setJobs(JobExperience jobExperience);

}

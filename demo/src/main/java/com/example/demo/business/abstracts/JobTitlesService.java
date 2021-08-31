package com.example.demo.business.abstracts;

import java.util.List;

import com.example.demo.core.concretes.utilities.result.DataResult;
import com.example.demo.core.concretes.utilities.result.Result;
import com.example.demo.entities.concretes.JobTitles;

public interface JobTitlesService {
	Result setJobTitless(JobTitles jobTitles);
	DataResult<List<JobTitles>> getAll();
	
}

package com.example.demo.business.abstracts;

import java.util.List;

import com.example.demo.core.concretes.utilities.result.DataResult;
import com.example.demo.core.concretes.utilities.result.Result;
import com.example.demo.entities.concretes.JobTitles;
import com.example.demo.entities.concretes.SystemEmployeeJobPosition;

public interface SystemEmployeeJobPositionService {
	Result setJobPositions(SystemEmployeeJobPosition systemEmployeeJobPosition);
	DataResult<List<SystemEmployeeJobPosition>> getAll();
}

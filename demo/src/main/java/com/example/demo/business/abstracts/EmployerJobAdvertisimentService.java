package com.example.demo.business.abstracts;

import java.util.List;

import com.example.demo.core.concretes.utilities.result.DataResult;
import com.example.demo.core.concretes.utilities.result.Result;
import com.example.demo.entities.concretes.EmployerJobAdvertisiment;
import com.example.demo.entities.concretes.SystemEmployeeJobPosition;

public interface EmployerJobAdvertisimentService {
	Result setAdvertisiment(EmployerJobAdvertisiment employerJobAdvertisiment);
	DataResult<List<EmployerJobAdvertisiment>> getAll();
	String getPositions();
	DataResult<List<EmployerJobAdvertisiment>> getByIsActive(boolean isActive);
	DataResult<List<EmployerJobAdvertisiment>> getByDateExplainsAndIsActive(String dateExplains,boolean isActive);
	Result getByIdAndIsActiveToDeActive(int id,boolean isActive);
	DataResult<List<EmployerJobAdvertisiment>> getByEmployerIdAndIsActive(int employerId,boolean isActive);

	
}

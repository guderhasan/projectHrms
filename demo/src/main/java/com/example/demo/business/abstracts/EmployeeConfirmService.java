package com.example.demo.business.abstracts;

import java.util.List;

import com.example.demo.core.concretes.utilities.result.DataResult;
import com.example.demo.entities.concretes.EmployeeConfirms;

public interface EmployeeConfirmService {
	DataResult<List<EmployeeConfirms>> getAll();
	boolean getConfirms();

}

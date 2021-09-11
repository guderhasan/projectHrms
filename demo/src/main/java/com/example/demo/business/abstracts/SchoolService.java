package com.example.demo.business.abstracts;

import java.util.List;

import com.example.demo.core.concretes.utilities.result.DataResult;
import com.example.demo.core.concretes.utilities.result.Result;
import com.example.demo.entities.concretes.City;
import com.example.demo.entities.concretes.Cv;
import com.example.demo.entities.concretes.Employee;
import com.example.demo.entities.concretes.School;

public interface SchoolService {
Result setSchool(School school);
DataResult<List<School>> getEmployeesSchools(int foreignSchoolId);

}

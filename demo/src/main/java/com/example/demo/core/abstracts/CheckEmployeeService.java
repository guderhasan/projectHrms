package com.example.demo.core.abstracts;

import com.example.demo.entities.concretes.Employee;

public interface CheckEmployeeService {
	public boolean ifReal(Employee employee);
	public boolean isNotEmpty(Employee employee);
	public boolean checkMail(String email);
	public boolean checkTcId(String tcid);
	public boolean signCheck(Employee employee);
    public boolean isEqualsPassword(Employee employee );
    public boolean isCode();

}

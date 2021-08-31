package com.example.demo.core.abstracts;

import com.example.demo.entities.concretes.Employee;
import com.example.demo.entities.concretes.Employer;

public interface CheckEmployerService {
	public boolean ifRealCompany();
	public boolean isNotEmpty(Employer employer);
	public boolean checkMail(String email);
	public boolean ifEqualDomain(Employer employer);
	public boolean signCheck(Employer employer);
    public boolean isEqualsPassword(Employer employer );
    public boolean isCode();
}

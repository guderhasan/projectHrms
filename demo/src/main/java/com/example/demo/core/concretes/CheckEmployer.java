package com.example.demo.core.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.business.abstracts.EmployeeConfirmService;
import com.example.demo.business.abstracts.VerificationsCodesService;
import com.example.demo.core.abstracts.CheckEmployerService;
import com.example.demo.dataAccess.abstracts.EmployeeDao;
import com.example.demo.dataAccess.abstracts.EmployerDao;
import com.example.demo.entities.concretes.Employer;
@Service
public class CheckEmployer implements CheckEmployerService{
private boolean resultEmpty;
private boolean resultMail;
private boolean resultPassword;
private boolean resultCode;
private boolean  result;
private boolean  resultDomain;
private boolean  resultRealCompany;

String webAdress;
String mail;
@Autowired
EmployeeConfirmService employeeConfirmService;




public CheckEmployer(EmployeeConfirmService employeeConfirmService) {
	super();
	this.employeeConfirmService = employeeConfirmService;
}


@Autowired
private VerificationsCodesService verificationsCodesService;


public CheckEmployer(VerificationsCodesService verificationsCodesService) {
	super();
	this.verificationsCodesService = verificationsCodesService;
}


private EmployerDao employerDao;



@Autowired
	public CheckEmployer(EmployerDao employerDao) {
	super();
	this.employerDao = employerDao;
}
	@Override
	public boolean ifRealCompany() {
		if(employeeConfirmService.getConfirms()) {
			resultRealCompany=true;
		}
		else {
	System.out.println("Şirket Doğrulanamadı");
			resultRealCompany=false;
		}
		return resultRealCompany;
	}

	@Override
	public boolean isNotEmpty(Employer employer) {
		if(employer.getEmail().isEmpty()||employer.getPassword().isEmpty()||employer.getCompany_name().isEmpty()||employer.getPhone_number().isEmpty()||employer.getWe_adress().isEmpty()||employer.getPassword2().isEmpty()){
			
			System.out.println("Kullanıcı Alanları Boş Olamaz");

			resultEmpty=false;
			
				}
		else {
			resultEmpty=true;

		}
		return resultEmpty;
	
	}

	@Override
	public boolean checkMail(String email) {
		if(employerDao.existsUserByEmail(email)) {
			System.out.println("Bu mail zaten var");

			resultMail=false;
		}
		else {
			resultMail=true;

		}
		return resultMail;
	}
//Öylesine bir web-mail eşitliği kontrolü yaptık
	@Override
	public boolean ifEqualDomain(Employer employer) {
		if(employer.getWe_adress().equals(employer.getEmail())) {
			resultDomain=true;
		}
		else {
			System.out.println("Email Domain İle Eşleşmiyor");
			resultDomain=false;
		}
		return resultDomain;
	}

	@Override
	public boolean signCheck(Employer employer) {
		if(this.checkMail(employer.getEmail())&&this.isCode()&&this.isEqualsPassword(employer)&&this.isNotEmpty(employer)&&this.ifEqualDomain(employer)&&this.ifRealCompany()) {
			result=true;

		}
		else {
			result=false;

		}
		return result;
	}

	@Override
	public boolean isEqualsPassword(Employer employer) {
		if(employer.getPassword().equals(employer.getPassword2())) {
			resultPassword=true;
		}
		else {
			System.out.println("Şifreler Eşleşmiyor");
			resultPassword=false;
		}
		return resultPassword;
	}

	@Override
	public boolean isCode() {
		if(verificationsCodesService.getVerificationsCodes().equals("HGMAS12345")) {
			resultCode=true;
		}
		else {
			System.out.println("Mail Kod ile Girdiğiniz Kod Eşleşmiyor");
			resultCode=false;
		}
				
				return resultCode;
	}


}

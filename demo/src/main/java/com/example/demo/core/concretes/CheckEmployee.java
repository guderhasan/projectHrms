package com.example.demo.core.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.business.abstracts.VerificationsCodesService;
import com.example.demo.core.abstracts.CheckEmployeeService;
import com.example.demo.core.abstracts.MernisServiceAdaptorService;
import com.example.demo.core.concretes.utilities.result.DataResult;
import com.example.demo.core.concretes.utilities.result.ErrorResult;
import com.example.demo.core.concretes.utilities.result.Result;
import com.example.demo.core.concretes.utilities.result.SuccessResult;
import com.example.demo.dataAccess.abstracts.EmployeeDao;
import com.example.demo.entities.concretes.Employee;
import com.example.demo.entities.concretes.Users;
@Service
public class CheckEmployee implements CheckEmployeeService{

	@Autowired
	private VerificationsCodesService verificationsCodesService;
	
	
	public CheckEmployee(VerificationsCodesService verificationsCodesService) {
		super();
		this.verificationsCodesService = verificationsCodesService;
	}

	private EmployeeDao employeeDao;

	

	@Autowired
		public CheckEmployee(EmployeeDao employeeDao) {
		super();
		this.employeeDao = employeeDao;
	}
	
		


		
		private boolean result;
		private boolean resultMail;
		private boolean resultTcId;
		private boolean resultEmpty;
		private boolean resultReal;
        private boolean resultPassword;
	    private boolean resultCode;

		
	@Autowired
		private MernisServiceAdaptorService mernisServiceAdaptorService;

		public CheckEmployee(MernisServiceAdaptorService mernisServiceAdaptorService) {
			super();
			this.mernisServiceAdaptorService = mernisServiceAdaptorService;
		}
		
		public boolean checkMail(String email) {
			if(employeeDao.existsUserByEmail(email)) {
				System.out.println("Bu mail zaten var");

				resultMail=false;
			}
			else {
				resultMail=true;

			}
			return resultMail;
		}
	public boolean checkTcId(String tcid) {
		if(employeeDao.existsByIdentityNumber(tcid) ){
			System.out.println("Bu tc no zaten var");
			resultTcId=false;
		}
		else {
			resultTcId=true;
		}
		return resultTcId;
		
	}

	@Override
	public boolean isNotEmpty(Employee employee) {

			if(employee.getEmail().isEmpty()||employee.getPassword().isEmpty()||employee.getFirstName().isEmpty()||employee.getLastName().isEmpty()||employee.getBirthYear()==0){
				
				System.out.println("Kullanıcı Alanları Boş Olamaz");

				resultEmpty=false;
				
					}
			else {
				resultEmpty=true;

			}
			return resultEmpty;
		
		
	}
	@Override
	public boolean ifReal(Employee employee) {
		if(mernisServiceAdaptorService.ifRealPerson(employee)) {
			resultReal=true;
		}
		else {
			System.out.println("Böyle bir kişi yok");
			resultReal=false;

		}
		return resultReal;
	}
	
	
	@Override
	public boolean isEqualsPassword(Employee employee) {
		
		if(employee.getPassword().equals(employee.getPassword2())) {
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
	@Override
	public boolean signCheck(Employee employee) {
		//Mernis Ekle	
	if(this.checkMail(employee.getEmail())&&this.checkTcId(employee.getIdentityNumber())&&this.isNotEmpty(employee)&&this.isEqualsPassword(employee)&&this.isCode()) {
			result=true;

		}
		else {
			result=false;

		}
		return result;
	}

	
}

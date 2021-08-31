package com.example.demo.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.business.abstracts.VerificationsCodesService;
import com.example.demo.core.concretes.utilities.result.DataResult;
import com.example.demo.core.concretes.utilities.result.Result;
import com.example.demo.core.concretes.utilities.result.SuccessDataResult;
import com.example.demo.core.concretes.utilities.result.SuccessResult;
import com.example.demo.dataAccess.abstracts.VerificationsCodesDao;
import com.example.demo.entities.concretes.Users;
import com.example.demo.entities.concretes.VerficationCodes;
@Service
public class VerficatiionsCodesEmployeeManager implements VerificationsCodesService{
	String code;
	private VerificationsCodesDao verficationsCodesDao;
@Autowired
	public VerficatiionsCodesEmployeeManager(VerificationsCodesDao verficationsCodesDao) {
	super();
	this.verficationsCodesDao = verficationsCodesDao;
}

	@Override
	public DataResult<List<VerficationCodes>> getAll() {
		// TODO Auto-generated method stub
		
		return new SuccessDataResult<List<VerficationCodes>>(this.verficationsCodesDao.findAll(),"Kodlar Listelendi");
		

	}
	@Override
	public String getVerificationsCodes() {
	
	
		for(VerficationCodes verificationCodes:this.verficationsCodesDao.findAll()) {
			code=verificationCodes.getCode();
		}
		
		return code;
	}
	@Override
	public Result sendMail(VerficationCodes verficationCodes) {
		// Sanki email göndermişiz gibi simule ettik
		 verficationsCodesDao.save(verficationCodes);
		 
		return new SuccessResult("Email Gönderildi");
	}
	
	
	

}

package com.example.demo.core.concretes;

import java.rmi.RemoteException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.core.abstracts.CheckService;
import com.example.demo.core.abstracts.MernisServiceAdaptorService;
import com.example.demo.entities.concretes.Employee;
import com.example.demo.entities.concretes.Users;

import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;
@Service
public class MernisServiceAdaptor implements MernisServiceAdaptorService {

	
	public boolean ifRealPerson(Employee employee) {
		boolean result;
		
		KPSPublicSoapProxy client = new KPSPublicSoapProxy(); 
		
		try { 
			result = client.TCKimlikNoDogrula(Long.parseLong(employee.getIdentityNumber()),employee.getFirstName().toUpperCase(),employee.getLastName().toUpperCase(),employee.getBirthYear()); 
		}
	    catch (RemoteException e) { 
			result = false; 
			e.printStackTrace(); 
		}
		
		return result;
	}



	

	

	
}

package com.example.demo.business.abstracts;



import java.io.IOException;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.core.concretes.utilities.result.DataResult;
import com.example.demo.core.concretes.utilities.result.Result;
import com.example.demo.entities.concretes.City;
import com.example.demo.entities.concretes.Cv;
import com.example.demo.entities.concretes.School;


public interface CvService {
	Result setCv(Cv cv,MultipartFile multipartFile) throws IOException;
	DataResult <List<Cv>> getEmployeesCvs(int foreignCvId);
	
	
	
}

package com.example.demo.business.concretes;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.business.abstracts.CvService;
import com.example.demo.core.abstracts.CloudinaryServiceAdaptorService;
import com.example.demo.core.concretes.utilities.result.DataResult;
import com.example.demo.core.concretes.utilities.result.Result;
import com.example.demo.core.concretes.utilities.result.SuccessDataResult;
import com.example.demo.core.concretes.utilities.result.SuccessResult;
import com.example.demo.dataAccess.abstracts.CvDao;
import com.example.demo.entities.concretes.Cv;
import com.example.demo.entities.concretes.School;




@Service
public class CvManager implements CvService{

	
	@Autowired
	private CloudinaryServiceAdaptorService cloudinaryServiceAdaptorService;
	
	public CvManager(CloudinaryServiceAdaptorService cloudinaryServiceAdaptorService) {
		super();
		this.cloudinaryServiceAdaptorService = cloudinaryServiceAdaptorService;
	}





	private CvDao cvDao;
	



	@Autowired
	public CvManager(CvDao cvDao) {
		super();
		this.cvDao = cvDao;
	}





	@Override
	public Result setCv(Cv cv,MultipartFile multipartFile) throws IOException {
	this.cloudinaryServiceAdaptorService.uploadImage(multipartFile);

cv.setPhotoLinks(this.cloudinaryServiceAdaptorService.getUrl());

System.out.println(this.cloudinaryServiceAdaptorService.getUrl());
this.cvDao.save(cv);
return new SuccessResult("Cv Başarıyla Eklendi");
	
	
	}





	@Override
	public DataResult<List<Cv>> getEmployeesCvs(int foreignCvId) {
		
		return new SuccessDataResult<List<Cv>>(this.cvDao.getByEmployee_ForeignCvId(foreignCvId),"Data Listelendi");
	
	}









	




	
}

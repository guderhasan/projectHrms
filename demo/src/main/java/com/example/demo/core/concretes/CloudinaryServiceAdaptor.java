package com.example.demo.core.concretes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import javax.imageio.stream.FileImageOutputStream;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.demo.core.abstracts.CloudinaryServiceAdaptorService;
@Service
public class CloudinaryServiceAdaptor implements CloudinaryServiceAdaptorService{
String url;
	@Override
	public void uploadImage(MultipartFile multipartFile) throws IOException {


		Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
				"cloud_name", "dnonbv2qt", 
				"api_key", "462861535755288",
				"api_secret", "fpGX_P03AxZHDrmFgT-C16VA4sM",
				"secure", true));

		File file = convert(multipartFile);
		Map uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
		file.delete();
		this.url=(String) uploadResult.get("url");
	}
private File convert(MultipartFile multipartFile) throws FileNotFoundException, IOException {
	File file=new File(multipartFile.getOriginalFilename());
	FileImageOutputStream fileImageOutputStream=new FileImageOutputStream(file);
	fileImageOutputStream.write(multipartFile.getBytes());
	fileImageOutputStream.close();
	return file;
	
	
}
@Override
public String getUrl() {
	// TODO Auto-generated method stub
	return null;
}
@Override
public String getUrl(String url) {
	// TODO Auto-generated method stub
	return this.url;
}



}

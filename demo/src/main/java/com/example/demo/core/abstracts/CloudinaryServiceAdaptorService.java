package com.example.demo.core.abstracts;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface CloudinaryServiceAdaptorService {
 void uploadImage(MultipartFile multipartFile) throws IOException;
String  getUrl();
String getUrl(String url);
}

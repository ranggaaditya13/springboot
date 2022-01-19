package com.rangga.upload.controllers;

import java.io.File;
import java.io.IOException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileControllerRest {
	
public static final String uploadGambar = System.getProperty("user.dir")+"/Foto/";
	
	@PostMapping("upload")
	public void uploadFile(@RequestParam("uploadFiles") MultipartFile[] uploadFiles) throws IOException{
		for(MultipartFile uploadFile : uploadFiles) {
			File file = new File(uploadGambar+uploadFile.getOriginalFilename());
			uploadFile.transferTo(file);
		}
	}

}

package com.rangga.upload;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rangga.upload.controllers.FileControllerRest;

@SpringBootApplication
public class UploadGambarApplication {

	public static void main(String[] args) {
		new File(FileControllerRest.uploadGambar).mkdir();
		SpringApplication.run(UploadGambarApplication.class, args);
	}

}

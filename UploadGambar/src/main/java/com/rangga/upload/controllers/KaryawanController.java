package com.rangga.upload.controllers;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.rangga.upload.models.KaryawanModel;
import com.rangga.upload.services.KaryawanService;

@RestController
public class KaryawanController {
	public static final String uploadGambar = System.getProperty("user.dir")+"/Foto/";
	
	@Autowired
	private KaryawanService ks;
	
	@GetMapping("/data")
	public List<KaryawanModel> listData(){
		return ks.listKaryawan();
	}
	
	@PostMapping("/insertdata")
	public int insertData(@RequestParam("foto") MultipartFile[] uploadFiles,
			@RequestParam("nama")String nama,
			@RequestParam("posisi") String posisi,
			@RequestParam("jenis_kelamin") String jenis_kelamin) throws IOException{
		String namaFile = "" ;
		for(MultipartFile uploadedFile : uploadFiles) {
			File file = new File(uploadGambar+uploadedFile.getOriginalFilename());
			uploadedFile.transferTo(file);
			namaFile = file.toString();
		}
		ks.insertData(nama, posisi, jenis_kelamin,"/gbr/"+namaFile);
		return 0;
	}


}

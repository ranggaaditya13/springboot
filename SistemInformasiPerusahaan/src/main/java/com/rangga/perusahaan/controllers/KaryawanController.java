package com.rangga.perusahaan.controllers;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rangga.perusahaan.models.KaryawanModel;
import com.rangga.perusahaan.services.KaryawanService;

@RestController
@RequestMapping("/karyawan")
public class KaryawanController {
	
	private Logger log = LogManager.getLogger(KaryawanController.class.getName());
	
	@Autowired
	private KaryawanService ks;
	
	@RequestMapping("/add")
	public int insertKaryawan(@RequestBody KaryawanModel km) {
		log.info("Data Berhasil Ditambahkan");
		return ks.insertKaryawan(km.getNis(), km.getNama(), km.getTempatLahir(),
				km.getTanggalLahir(), km.getAlamat(), km.getNoHp());	
	}
	
	@GetMapping("/data")
	public List<Map<String, Object>> getAllData(){
		log.info("Data Berhasil Diambil");
		return ks.getAllData();
	}
	
	@RequestMapping("/delete")
	public void deleteData(@RequestBody KaryawanModel km) {
		log.info("Data Berhasil Dihapus");
		ks.deleteDataQuery(km.getNis());
	}
	
	@RequestMapping("/update")
	public String updateData (@RequestBody KaryawanModel km){
		ks.updateData(km.getNama(),km.getTempatLahir(),km.getTanggalLahir(),
		km.getAlamat(),km.getNoHp(),km.getNis());
		log.info("Data Berhasil di ubah");
		return "data Berhasil diubah";
		}
	
	

}

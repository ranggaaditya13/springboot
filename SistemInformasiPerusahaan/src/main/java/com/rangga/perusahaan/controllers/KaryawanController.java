package com.rangga.perusahaan.controllers;

import java.util.List;
import java.util.Map;

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
	
	@Autowired
	private KaryawanService ks;
	
	@RequestMapping("/add")
	public int insertKaryawan(@RequestBody KaryawanModel km) {
		return ks.insertKaryawan(km.getNis(), km.getNama(), km.getTempatLahir(),
				km.getTanggalLahir(), km.getAlamat(), km.getNoHp());
	
	}
	
	@GetMapping("/data")
	public List<Map<String, Object>> getAllData(){
		return ks.getAllData();
	}
	
	@RequestMapping("/delete")
	public void deleteData(@RequestBody KaryawanModel km) {
		ks.deleteDataQuery(km.getNis());
	}
	
	@RequestMapping("/update")
	public void updateData (@RequestBody KaryawanModel km){
		ks.updateData(km.getNama(),km.getTempatLahir(),km.getTanggalLahir(),
		km.getAlamat(),km.getNoHp(),km.getNis());
		}

}

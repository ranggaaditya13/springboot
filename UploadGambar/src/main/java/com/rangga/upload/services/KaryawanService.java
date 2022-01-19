package com.rangga.upload.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rangga.upload.models.KaryawanModel;
import com.rangga.upload.repositories.KaryawanRepository;

@Service
@Transactional
public class KaryawanService {
	
	@Autowired
	private KaryawanRepository kr;
	
	public int insertData(String nama, String posisi, String jenis_kelamin, String foto) {
		return kr.insertData(nama, posisi, jenis_kelamin, foto);
	}
	
	public List<KaryawanModel> listKaryawan(){
		return kr.listKaryawan();
	}

}

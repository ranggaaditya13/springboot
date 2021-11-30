package com.rangga.perusahaan.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rangga.perusahaan.models.KaryawanModel;
import com.rangga.perusahaan.repositories.KaryawanRepository;

@Service
@Transactional
public class KaryawanService {
	//Service Digunakan Untuk Logic
	
	@Autowired
	private KaryawanRepository kr;
	
	public int insertKaryawan(String nis,String nama,String tanggalLahir,
			String tempatLahir,String alamat,String noHp) {
		if(nis == null || nama == null || tanggalLahir == null || tempatLahir == null
				|| alamat == null || noHp == null) {
			return 0;
			
		}else {
			
			return kr.insertKaryawan(nis, nama, tanggalLahir, tempatLahir, alamat, noHp);
		}
	}
	
	public List<Map<String, Object>> getAllData(){
		return kr.getAllData();
	}
	
	/*
	 * public void deleteData(String nis) { kr.deleteById(nis); }
	 */
	public int deleteDataQuery(String nis) {
		return kr.deleteDataQuery(nis);
	}
		
	public int updateData (String nama,String tanggalLahir,
			String tempatLahir,String alamat,String noHp,String nis){
		return kr.updateData(nama, tanggalLahir, tempatLahir, alamat, noHp, nis);
	}

}

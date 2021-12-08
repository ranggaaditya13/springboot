package com.mega.redis.dao;

import java.util.Map;

import com.mega.redis.model.KaryawanModel;

public interface KaryawanDao {
	
	void saveKaryawan(KaryawanModel karyawan);
	KaryawanModel getKaryawanById(Integer id);
	void updateKaryawan(KaryawanModel karyawan);
	Map<Integer, KaryawanModel> getAllData();
	void deleteKaryawan(Integer id);
	void saveAll(Map<Integer, KaryawanModel>map);

}

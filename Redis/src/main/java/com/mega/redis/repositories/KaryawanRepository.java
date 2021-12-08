package com.mega.redis.repositories;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Repository;

import com.mega.redis.dao.KaryawanDao;
import com.mega.redis.model.KaryawanModel;

@Repository
public class KaryawanRepository implements KaryawanDao{
	
	private final String Referensi = "KaryawanModel";
	
	 	@Resource(name="redisTemplate")          // 'redisTkaryawanlate' is defined as a Bean in AppConfig.java
	    private HashOperations<String, Integer, KaryawanModel> hashOperations;

		@Override 
	    public void saveKaryawan(KaryawanModel karyawan) {
	       
	        hashOperations.putIfAbsent(Referensi, karyawan.getId(), karyawan);
	    }

	    @Override
	    public void saveAll(Map<Integer, KaryawanModel> map) {
	        hashOperations.putAll(Referensi, map);
	    }

	    @Override
	    public KaryawanModel getKaryawanById(Integer id) {
	       return hashOperations.get(Referensi, id);
	    }

	    @Override
	    public void updateKaryawan(KaryawanModel karyawan) {
	       hashOperations.put(Referensi, karyawan.getId(), karyawan);
	    }

	    @Override
	    public Map<Integer, KaryawanModel> getAllData() {
	       return hashOperations.entries(Referensi);
	    }

	    @Override
	    public void deleteKaryawan(Integer id) {
	       hashOperations.delete(Referensi, id);
	    }
	

}

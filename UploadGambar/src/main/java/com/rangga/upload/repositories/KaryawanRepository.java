package com.rangga.upload.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.rangga.upload.models.KaryawanModel;

public interface KaryawanRepository extends JpaRepository<KaryawanModel, String>{
	
	@Query(value = "select * from karyawan",nativeQuery=true)
	List<KaryawanModel> listKaryawan();
	
	@Modifying
	@Query(value = "insert into karyawan(nama,posisi,jenis_kelamin,foto) values(?1,?2,?3,?4)",nativeQuery = true)
	int insertData(String nama, String posisi, String jenis_kelamin, String foto);

}

package com.rangga.perusahaan.repositories;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.rangga.perusahaan.models.KaryawanModel;

public interface KaryawanRepository extends JpaRepository<KaryawanModel, String> {
	
	//created by masih default belum jadi dinamis
	@Modifying
	@Query(value = "insert into karyawan(nis,nama,tanggal_lahir,tempat_lahir,alamat,no_hp,created_by,created_on)"
			+ " values(?1,?2,?3,?4,?5,?6,1,now())",nativeQuery = true)
	public int insertKaryawan(String nis,String nama,String tanggalLahir,
			String tempatLahir,String alamat,String noHp);
	
	@Query(value = "select nis,nama,tanggal_lahir,tempat_lahir,alamat,no_hp from karyawan"
			+ " where is_deleted = 0 order by nama",nativeQuery = true)
	public List<Map<String, Object>> getAllData();
	
	@Modifying
	@Query(value = "update karyawan set is_deleted = 1, deleted_by = 1, deleted_on = now() where nis = ?",nativeQuery = true)
	public int deleteDataQuery(String nis);
	
	//modified_by masih dalam keadaan default = 1
	@Modifying
	@Query(value = "update karyawan set nama =?1,tanggal_lahir = ?2,tempat_lahir = ?3,alamat = ?4,no_hp=?5, modified_by=1, modified_on = now()  "
			+ "where nis = ?6",nativeQuery = true)
	public int updateData (String nama,String tanggalLahir,
			String tempatLahir,String alamat,String noHp,String nis);
	
}

package com.rangga.elastic.mysql.repositories;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.rangga.elastic.mysql.models.ArticleModel;

@Transactional
public interface ArticleRepository extends JpaRepository<ArticleModel, Integer> {
	
	@Query(value = "select * from articles",nativeQuery = true)
	List<Map<String, Object>> listAll();
	
	@Modifying
	@Query(value = "delete from articles",nativeQuery = true)
	int deleteAllData();
	
	@Modifying
	@Query(value = "insert into articles(title,category) values(?1,?2)",nativeQuery = true)
	int addData(String title,String category);
	
	

}

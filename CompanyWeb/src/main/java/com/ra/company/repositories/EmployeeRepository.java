package com.ra.company.repositories;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ra.company.models.EmployeeModel;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeModel, Integer> {

	@Query(value="select * from employee",nativeQuery = true)
	public List<Map<String, Object>> listEmployee();
	
}

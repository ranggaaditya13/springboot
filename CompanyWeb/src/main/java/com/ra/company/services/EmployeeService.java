package com.ra.company.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ra.company.repositories.EmployeeRepository;

@Service
@Transactional
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository ep;
	
	public List<Map<String, Object>> listEmployee(){
		return ep.listEmployee();
	}

}

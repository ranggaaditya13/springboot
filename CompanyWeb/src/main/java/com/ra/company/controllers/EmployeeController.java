package com.ra.company.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.deser.std.StringArrayDeserializer;
import com.ra.company.models.AppLogsMongo;
import com.ra.company.models.EmployeeRedisModel;
import com.ra.company.repositories.AppLogsMongoRepository;
import com.ra.company.repositories.EmployeeRedisRepository;
import com.ra.company.services.EmployeeService;
import com.ra.company.utils.CustomLogger;


@RestController
public class EmployeeController {
	
	Logger log = LogManager.getLogger(EmployeeController.class.getName());
	
	@Autowired
	private EmployeeService es;
	
	@Autowired 
	private EmployeeRedisRepository err;
	
	@Autowired
	private CustomLogger logs;
	
	@Autowired
	private AppLogsMongoRepository amr;
	
	
	@GetMapping("all")
	public List<Map<String, Object>> listEmployee(){
		log.info(logs.info("Berhasil Mengambil Data"));
		return es.listEmployee();
	}
	
	@GetMapping("/logs")
	public ResponseEntity<List<AppLogsMongo>> getAllLogs(){
		try {
			
			List<AppLogsMongo> checkLogs = new  ArrayList<AppLogsMongo>();
			amr.findAll().forEach(checkLogs::add);
			log.info(logs.info("Data Berhasil Diambil"));
			return new ResponseEntity<>(checkLogs,HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	
	 @GetMapping("/redis")
	    public ResponseEntity<List<EmployeeRedisModel>> getEmployeeRedis() {
	        List<EmployeeRedisModel> emp = new ArrayList<>();
	        err.findAll().forEach(emp::add);
	        if(emp.size() < 1) {
	        	for(int i =0; i< es.listEmployee().size();i++) {
	        		int id = (int) es.listEmployee().get(i).get("id");
	        		String nama = (String) es.listEmployee().get(i).get("nama");
	        		String jenis_kelamin = (String) es.listEmployee().get(i).get("jenis_kelamin");
	        		String telephone = (String) es.listEmployee().get(i).get("telephone");
	        		
	        		EmployeeRedisModel empRedis = new EmployeeRedisModel();
	        		empRedis.setId(id);
	        		empRedis.setNama(nama);
	        		empRedis.setJenis_kelamin(jenis_kelamin);
	        		empRedis.setTelephone(telephone);
	        		err.save(empRedis);
	        		err.findAll().forEach(emp::add);
	        	}
	        	
	        	
	        }else {
	        	log.info(logs.info("Berhasil Mengambil Data Redis"));
	        	
	        }
	        System.out.println(emp.size());
	        return new ResponseEntity<>(emp, HttpStatus.OK);
	    }
}

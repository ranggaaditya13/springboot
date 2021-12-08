package com.mega.redis;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.mega.redis.model.KaryawanModel;
import com.mega.redis.repositories.KaryawanRepository;

@SpringBootApplication
@Component
public class RedisApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(RedisApplication.class, args);		
		
	}
	
	@Autowired
    private KaryawanRepository karyawan;

    @Override
    public void run(String... args) throws Exception {

           //saving one employee
    	karyawan.saveKaryawan(new KaryawanModel(500, "Emp0", "1jt"));

          //saving multiple employees
    	karyawan.saveAll(
            Map.of( 501, new KaryawanModel(501, "Emp1", "2jt"),
                    502, new KaryawanModel(502, "Emp2", "2jt"),
                    503, new KaryawanModel(503, "Emp4", "2jt")
                  )
       );

         //modifying employee with empId 503
    	karyawan.updateKaryawan(new KaryawanModel(503, "Emp3", "3jt"));

         //deleting employee with empID 500
    	karyawan.deleteKaryawan(500);

        //retrieving all employees
    	karyawan.getAllData().forEach((k,v)-> System.out.println(k +" : "+v.toString()));

        //retrieving employee with empID 501
       System.out.println("Emp details for 501 : "+karyawan.getKaryawanById(501));
    }
	
	
	
	

}

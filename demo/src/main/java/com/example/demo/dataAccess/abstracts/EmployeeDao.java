package com.example.demo.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.concretes.Employee;



	public interface EmployeeDao extends JpaRepository<Employee,Integer>{
		
         boolean existsByIdentityNumber(String identity_number);
    	 boolean existsUserByEmail(String email);

    	
	}


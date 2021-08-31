package com.example.demo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.concretes.Employee;



	public interface EmployeeDao extends JpaRepository<Employee,Integer>{
		
         boolean existsByIdentityNumber(String identity_number);
    	 boolean existsUserByEmail(String email);

	
	}


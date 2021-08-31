package com.example.demo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.concretes.Employee;
import com.example.demo.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer,Integer>{
	 boolean existsUserByEmail(String email);
}

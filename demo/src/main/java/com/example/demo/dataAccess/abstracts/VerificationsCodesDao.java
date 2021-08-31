package com.example.demo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.concretes.Users;
import com.example.demo.entities.concretes.VerficationCodes;
import java.util.List;
public interface VerificationsCodesDao extends JpaRepository<VerficationCodes,Integer>{
	
}

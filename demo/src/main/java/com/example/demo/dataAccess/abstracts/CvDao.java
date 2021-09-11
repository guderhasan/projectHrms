package com.example.demo.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.core.concretes.utilities.result.DataResult;
import com.example.demo.entities.concretes.Cv;
import com.example.demo.entities.concretes.School;

public interface CvDao  extends JpaRepository<Cv, Integer>{
	
	List<Cv>getByEmployee_ForeignCvId(int foreignCvId);

}

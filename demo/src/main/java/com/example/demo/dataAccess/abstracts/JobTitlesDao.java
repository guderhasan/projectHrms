package com.example.demo.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.concretes.JobTitles;
import com.example.demo.entities.concretes.Users;

public interface JobTitlesDao extends JpaRepository<JobTitles,Integer>{
	boolean existsByTitle(String title);
}

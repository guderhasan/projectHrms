package com.example.demo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.concretes.SystemEmployeeJobPosition;

public interface SystemEmployeeJobPositionDao extends JpaRepository<SystemEmployeeJobPosition, Integer>{

}

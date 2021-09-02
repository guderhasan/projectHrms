package com.example.demo.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.concretes.EmployerJobAdvertisiment;

public interface EmployerJobAdvertisimentDao extends JpaRepository<EmployerJobAdvertisiment, Integer> {
List<EmployerJobAdvertisiment> getByIsActive(boolean isActive);
List<EmployerJobAdvertisiment> getByDateExplainsAndIsActive(String dateExplains,boolean isActive);
List<EmployerJobAdvertisiment> getByIdAndIsActive(int id,boolean isActive);
List<EmployerJobAdvertisiment> getByEmployerIdAndIsActive(int employerId,boolean isActive);

} 

package com.example.demo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.concretes.ForeignLanguage;

public interface ForeignLanguageDao  extends JpaRepository<ForeignLanguage, Integer>{

}

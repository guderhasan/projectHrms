package com.example.demo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.concretes.Users;

public interface UsersDao extends JpaRepository<Users,Integer>{

}

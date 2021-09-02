package com.example.demo.entities.concretes;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Service;

import com.example.demo.entities.abstracts.IEntity;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@Service
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="cities")
public class City implements IEntity {
	    @Id
		@Column(name="id")
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int id;
		
	    @Column(name="cities")
	    private String cities;
	  
}

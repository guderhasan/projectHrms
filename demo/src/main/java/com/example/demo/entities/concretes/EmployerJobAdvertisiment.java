package com.example.demo.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="job_advertisiments")
public class EmployerJobAdvertisiment {
	        @Id
			@Column(name="id")
			@GeneratedValue(strategy=GenerationType.IDENTITY)
			private int id;
	        
	        @Column(name="employers_id")
	        private int employersId;
	        
	        @Column(name="job_positions")
	        private String jobPositions;
	        
	        @Column(name="job_explains")
	        private String jobExplains;
	        
	        @Column(name="cities")
	        private String cities;
	        
	        @Column(name="salaries")
	        private String salaries;
	        
	        @Column(name="free_positions")
	        private String freePositions;
	        
	        @Column(name="last_date_explains")
	        private String lastDateExplains;
	        
	        @Column(name="is_active")
	        private boolean isActive;
	        
	        @Column(name="date_explains")
	        private String dateExplains;
	        
	       
	        @ManyToOne()
	        @JoinColumn(name="employer_id")
	        private Employer employer;
		   

}

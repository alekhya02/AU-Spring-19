package com.accolite.miniau.hibernate;

import javax.persistence.Entity;

@Entity
public class Worker extends Employee{

	/*@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;*/
	private String dailyWage;

	public String getDailyWage() {
		return dailyWage;
	}

	public void setDailyWage(String dailyWage) {
		this.dailyWage = dailyWage;
	}
	
	
}

package com.accolite.miniau.hibernate;

import javax.persistence.*;

@Entity
public class Employee extends Person{
	
	/*@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;*/
	private String office;

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}
	

}

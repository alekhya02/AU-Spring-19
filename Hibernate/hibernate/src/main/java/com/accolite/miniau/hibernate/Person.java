package com.accolite.miniau.hibernate;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

import com.accolite.miniau.hibernate.Address;

// 10) Implementing Inheritance (single table,joined table)
@Entity(name="Person")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@Table(name="Person")
@NamedQueries({
	@NamedQuery(name ="new", query="from Person" )
})
public class Person {
//	3. Primary keys
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", presentAddress=" + presentAddress + ", permanentAddress="
				+ permanentAddress + ", phone=" + phone + "]";
	}


	/*
	 * 4) Value Types
	 * 5) AttributeOverrides and Embedded Objects
	 */
	@Embedded
	@AttributeOverrides({
	@AttributeOverride(name="street",column=@Column(name="present_street_name")),
	@AttributeOverride(name="city",column=@Column(name="present_city_name")),
	})
	private Address presentAddress;
	@Embedded
	@AttributeOverrides({
	@AttributeOverride(name="street",column=@Column(name="permanent_street_name")),
	@AttributeOverride(name="city",column=@Column(name="permanent_city_name")),
	})
	private Address permanentAddress;
	public Address getPresentAddress() {
		return presentAddress;
	}
	public void setPresentAddress(Address presentAddress) {
		this.presentAddress = presentAddress;
	}
	public Address getPermanentAddress() {
		return permanentAddress;
	}
	public void setPermanentAddress(Address permanentAddress) {
		this.permanentAddress = permanentAddress;
	}
	

	//  8) One To Many Mapping
	@OneToMany 
	Collection<Phone> phone=new ArrayList<Phone>();

	public Collection<Phone> getPhone() {
		return phone;
	}
	public void setPhone(Collection<Phone> phone) {
		this.phone = phone;
	}
	
}

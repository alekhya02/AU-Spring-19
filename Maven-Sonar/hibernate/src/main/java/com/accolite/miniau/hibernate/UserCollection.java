package com.accolite.miniau.hibernate;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "userCollection")
public class UserCollection {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ElementCollection(fetch = FetchType.EAGER)
	@JoinTable(name = "address", joinColumns = @JoinColumn(name = "user_id"))
	Set<Address> addresses = new HashSet<Address>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	@Override
	public String toString() {
		return "StdAddressCollection [id=" + id + ", addresses=" + addresses + "]";
	}
}


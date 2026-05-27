package com.comigo.vem.entities;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String cpf;
	private String name;
	private String email;
	private String birthDate;
	private String phone;
	
	@OneToOne
	@JoinColumn(name = "driver_id")
	private DriverData driverData;
	
	@OneToOne
	@JoinColumn(name = "address_id")
	private Address address;
	
	public User() {
	}

	public User(Long id, String cpf, String name, String email, String birthDate, String phone, Address address) {
		this.id = id;
		this.cpf = cpf;
		this.name = name;
		this.email = email;
		this.birthDate = birthDate;
		this.phone = phone;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public DriverData getDriverData() {
		return driverData;
	}

	public void setDriverData(DriverData driverData) {
		this.driverData = driverData;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}
	
}

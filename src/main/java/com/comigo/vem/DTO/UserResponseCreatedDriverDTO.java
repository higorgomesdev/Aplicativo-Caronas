package com.comigo.vem.DTO;

import com.comigo.vem.entities.User;

public class UserResponseCreatedDriverDTO {
	
	private Long id;
	private String name;
	private String email;
	private String phone;
	
	private DriverDataDTO driverData;
	
	public UserResponseCreatedDriverDTO() {
	}

	public UserResponseCreatedDriverDTO(Long id, String name, String email, String phone, DriverDataDTO driverData) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.driverData = driverData;
	}
	
	public UserResponseCreatedDriverDTO(User entity) {
		id = entity.getId();
		name = entity.getName();
		email = entity.getEmail();
		phone = entity.getPhone();
		driverData = new DriverDataDTO(entity.getDriverData());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public DriverDataDTO getDriverData() {
		return driverData;
	}

	public void setDriverData(DriverDataDTO driverData) {
		this.driverData = driverData;
	}
	
	
	
}

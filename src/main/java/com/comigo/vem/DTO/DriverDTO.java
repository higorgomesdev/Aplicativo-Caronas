package com.comigo.vem.DTO;

import com.comigo.vem.entities.User;

public class DriverDTO {
	
	private Long id;
	private String name;
	private String photoUrl;
	
	private DriverDataDTO driverData;
	
	public DriverDTO() {
	}

	public DriverDTO(Long id, String name, String photoUrl) {
		this.id = id;
		this.name = name;
		this.photoUrl = photoUrl;
	}
	
	public DriverDTO(User entity) {
		id = entity.getId();
		name = entity.getName();
		photoUrl = entity.getPhotoUrl();
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

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public DriverDataDTO getDriverData() {
		return driverData;
	}

	public void setDriverData(DriverDataDTO driverData) {
		this.driverData = driverData;
	}
	
	
}

package com.comigo.vem.DTO;

import com.comigo.vem.entities.DriverData;
import com.comigo.vem.entities.enums.ColorVehicle;

public class DriverDataDTO {
	
	private Long id;
	private String vehicleModel;
	private String licensePlate	;
	private ColorVehicle color;
	
	public DriverDataDTO() {
	}
	
	public DriverDataDTO(DriverData entity) {
		id = entity.getId();
		vehicleModel = entity.getVehicleModel();
		licensePlate = entity.getLicensePlate();
		color = entity.getColor();
	}
	
	public DriverDataDTO(Long id, String vehicleModel, String licensePlate, ColorVehicle color) {
		this.id = id;
		this.vehicleModel = vehicleModel;
		this.licensePlate = licensePlate;
		this.color = color;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVehicleModel() {
		return vehicleModel;
	}

	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public ColorVehicle getColor() {
		return color;
	}

	public void setColor(ColorVehicle color) {
		this.color = color;
	}
	
}

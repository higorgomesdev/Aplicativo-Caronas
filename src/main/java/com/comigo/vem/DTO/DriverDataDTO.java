package com.comigo.vem.DTO;

import com.comigo.vem.entities.DriverData;
import com.comigo.vem.entities.enums.ColorVehicle;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class DriverDataDTO {
	
	private Long id;
	@NotBlank(message = "campo obrigatorio")
	@Size(min = 9, max = 9, message = "Campo invalido")
	private String cnh;
	@NotBlank(message = "campo obrigatorio")
	private String vehicleModel;
	@NotBlank(message = "campo obrigatorio")
	@Size(min = 7, max = 7, message = "Campo invalido")
	private String licensePlate;
	@NotNull(message = "Campo obrigatorio")
	private ColorVehicle color;
	@NotBlank(message ="Campo obrigatorio")
	private String vehicleYear;
	
	public DriverDataDTO() {
	}
	
	public DriverDataDTO(DriverData entity) {
		id = entity.getId();
		cnh = entity.getCnh();
		vehicleModel = entity.getVehicleModel();
		licensePlate = entity.getLicensePlate();
		color = entity.getColor();
		vehicleYear = entity.getVehicleYear();
		
	}
	
	public DriverDataDTO(Long id, String vehicleModel, String licensePlate, ColorVehicle color, String vehicleYear) {
		this.id = id;
		this.vehicleModel = vehicleModel;
		this.licensePlate = licensePlate;
		this.color = color;
		this.vehicleYear= vehicleYear; ;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getCnh() {
		return cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
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

	public String getVehicleYear() {
		return vehicleYear;
	}

	public void setVehicleYear(String vehicleYear) {
		this.vehicleYear = vehicleYear;
	}
	
}

package com.comigo.vem.entities;

import java.util.Objects;

import com.comigo.vem.entities.enums.ColorVehicle;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_driver_data")
public class DriverData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String cnh;
	private String vehicleModel;
	private String licensePlate	;
	@Enumerated(EnumType.STRING)
	private ColorVehicle color;
	
	public DriverData() {
	}

	public DriverData(Long id, String cnh, String vehicleModel, String licensePlate, ColorVehicle color) {
		this.id = id;
		this.cnh = cnh;
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
		DriverData other = (DriverData) obj;
		return Objects.equals(id, other.id);
	}
	
	

}

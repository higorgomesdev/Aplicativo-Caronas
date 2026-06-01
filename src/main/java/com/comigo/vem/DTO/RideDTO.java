package com.comigo.vem.DTO;

import java.time.Instant;

import com.comigo.vem.entities.Ride;
import com.comigo.vem.entities.enums.StatusRide;

public class RideDTO {

	private Long id;
	private Instant departureTime;
	private Integer capacity;
	private Double price;
	private StatusRide status;
	
	private DriverDTO driver;
	
	private LocationDTO starting;
	
	private LocationDTO destination;
	
	public RideDTO() {
	}

	public RideDTO(Long id, Instant departureTime, Integer capacity, Double price, StatusRide status, DriverDTO driver,
			LocationDTO starting, LocationDTO destination) {
		this.id = id;
		this.departureTime = departureTime;
		this.capacity = capacity;
		this.price = price;
		this.status = status;
		this.driver = driver;
		this.starting = starting;
		this.destination = destination;
	}
	
	public RideDTO(Ride entity) {
		id = entity.getId();
		departureTime = entity.getDepartureTime();
		capacity = entity.getCapacity();
		price = entity.getPrice();
		status = entity.getStatus();
		driver = new DriverDTO(entity.getDriver());
		starting = new LocationDTO(entity.getStartingLocation());
		destination = new LocationDTO(entity.getDestinationLocation());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Instant departureTime) {
		this.departureTime = departureTime;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public StatusRide getStatus() {
		return status;
	}

	public void setStatus(StatusRide status) {
		this.status = status;
	}

	public DriverDTO getDriver() {
		return driver;
	}

	public void setDriver(DriverDTO driver) {
		this.driver = driver;
	}

	public LocationDTO getStarting() {
		return starting;
	}

	public void setStarting(LocationDTO starting) {
		this.starting = starting;
	}

	public LocationDTO getDestination() {
		return destination;
	}

	public void setDestination(LocationDTO destination) {
		this.destination = destination;
	}
	
	
}

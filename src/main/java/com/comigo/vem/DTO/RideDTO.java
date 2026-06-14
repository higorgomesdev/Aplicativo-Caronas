package com.comigo.vem.DTO;

import java.time.Instant;

import com.comigo.vem.entities.Ride;
import com.comigo.vem.entities.enums.StatusRide;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Negative;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class RideDTO {

	private Long id; 
	@NotNull(message = "Campor obrigatorio")
	@Future(message = "A viagem deve ser agendada para uma data futura")
	private Instant departureTime; 
	@NotNull(message = "Campor obrigatorio")
	private Integer capacity; 
	@NotNull(message = "Campor obrigatorio")
	@Positive(message = "Valor tem que ser maior que zero")
	private Double price;

	private StatusRide status; 
	

	private DriverDTO driver;
	
	@NotNull(message = "Campor obrigatorio")
	private LocationDTO starting;
	
	@NotNull(message = "Campor obrigatorio")
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

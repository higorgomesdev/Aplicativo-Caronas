package com.comigo.vem.DTO;

import java.time.Instant;

import com.comigo.vem.entities.Booking;
import com.comigo.vem.entities.enums.StatusBooking;

public class BookingDTO {
	
	private Long id;
	private Instant instantBooking;
	private StatusBooking status;
	private Integer reservedSeats;
	private Long rideId;
	private UserResponseMinDTO user;
	
	public BookingDTO() {
	}

	public BookingDTO(Long id, Instant instantBooking, StatusBooking status, Integer reservedSeats, Long rideId,
			UserResponseMinDTO user) {
		this.id = id;
		this.instantBooking = instantBooking;
		this.status = status;
		this.reservedSeats = reservedSeats;
		this.rideId = rideId;
		this.user = user;
	}
	
	public BookingDTO(Booking entity) {
		id = entity.getId();
		instantBooking = entity.getInstantBooking();
		status = entity.getStatus();
		reservedSeats = entity.getSeats();
		rideId = entity.getRide().getId();
		user = new UserResponseMinDTO(entity.getUser());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getInstantBooking() {
		return instantBooking;
	}

	public void setInstantBooking(Instant instantBooking) {
		this.instantBooking = instantBooking;
	}

	public StatusBooking getStatus() {
		return status;
	}

	public void setStatus(StatusBooking status) {
		this.status = status;
	}

	public Integer getReservedSeats() {
		return reservedSeats;
	}

	public void setReservedSeats(Integer reservedSeats) {
		this.reservedSeats = reservedSeats;
	}

	public Long getRideId() {
		return rideId;
	}

	public void setRideId(Long rideId) {
		this.rideId = rideId;
	}

	public UserResponseMinDTO getUser() {
		return user;
	}

	public void setUser(UserResponseMinDTO user) {
		this.user = user;
	}
	
	
}

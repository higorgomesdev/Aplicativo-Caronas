package com.comigo.vem.entities;

import java.time.Instant;
import java.util.Objects;

import com.comigo.vem.entities.enums.StatusBooking;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_booking")
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Instant instantBooking;
	@Enumerated(EnumType.STRING)
	private StatusBooking status;

	
	@ManyToOne
	@JoinColumn(name = "ride_id")
	private Ride ride;
	
	@ManyToOne
	@JoinColumn(name = "passenger_id")
	private User user;

	public Booking() {
	}
	
	public Booking(Long id, Instant instantBooking, StatusBooking status, Ride ride, User user) {
		this.id = id;
		this.instantBooking = instantBooking;
		this.status = status;
		this.ride = ride;
		this.user = user;
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

	public Ride getRide() {
		return ride;
	}

	public void setRide(Ride ride) {
		this.ride = ride;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
		Booking other = (Booking) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}

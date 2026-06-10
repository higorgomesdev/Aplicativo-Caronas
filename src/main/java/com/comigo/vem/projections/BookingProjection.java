package com.comigo.vem.projections;

import java.time.Instant;

import com.comigo.vem.entities.Ride;
import com.comigo.vem.entities.User;
import com.comigo.vem.entities.enums.StatusBooking;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public interface BookingProjection {
	
	Long getId();
	Instant getInstantBooking();
	StatusBooking getStatus();
	Integer getSeats();
	Ride getRide();
	User getPass();


}

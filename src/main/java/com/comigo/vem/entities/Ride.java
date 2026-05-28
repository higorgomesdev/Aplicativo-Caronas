package com.comigo.vem.entities;

import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.comigo.vem.entities.enums.StatusRide;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_ride")
public class Ride {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Instant departureTime;
	private Integer capacity;
	private Double price;
	private StatusRide status;
	
	@ManyToOne
	private User driver;
	
	@OneToMany(mappedBy = "ride")
	private Set<Booking> bookings = new HashSet<>();
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "state", column = @Column(name = "starting_state")),
		@AttributeOverride(name = "city", column = @Column(name = "starting_city")),
		@AttributeOverride(name = "neighborhood", column = @Column(name = "starting_neighborhood")),
		@AttributeOverride(name = "street", column = @Column(name = "starting_street")),
		@AttributeOverride(name = "meetingPoint", column = @Column(name = "starting_Point"))})
	private Location startingLocation;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "state", column = @Column(name = "destination_state")),
		@AttributeOverride(name = "city", column = @Column(name = "destination_city")),
		@AttributeOverride(name = "neighborhood", column = @Column(name = "destination_neighborhood")),
		@AttributeOverride(name = "street", column = @Column(name = "destination_street")),
		@AttributeOverride(name = "meetingPoint", column = @Column(name = "destination_Point"))
	})
	private Location destinationLocation;
	
	public Ride() {
	}

	public Ride(Long id, Instant departureTime, Integer capacity, Double price, StatusRide status, User driver,
			Location startingLocation, Location destinationLocation) {
		this.id = id;
		this.departureTime = departureTime;
		this.capacity = capacity;
		this.price = price;
		this.status = status;
		this.driver = driver;
		this.startingLocation = startingLocation;
		this.destinationLocation = destinationLocation;
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

	public User getDriver() {
		return driver;
	}

	public void setDriver(User motorista) {
		this.driver = motorista;
	}

	public Location getStartingLocation() {
		return startingLocation;
	}

	public void setStartingLocation(Location startingLocation) {
		this.startingLocation = startingLocation;
	}

	public Location getDestinationLocation() {
		return destinationLocation;
	}

	public void setDestinationLocation(Location destinationLocation) {
		this.destinationLocation = destinationLocation;
	}

	public Set<Booking> getBookings() {
		return bookings;
	}

	public void addBooking(Booking booking) {
		bookings.add(booking);
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
		Ride other = (Ride) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}















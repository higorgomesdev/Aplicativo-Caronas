package com.comigo.vem.DTO;

import com.comigo.vem.entities.Location;

public class LocationDTO {

	private String state;
	private String city;
	private String neighborhood;
	private String street;
	private String meetingPoint;
	
	public LocationDTO() {
	}

	public LocationDTO(String state, String city, String neighborhood, String street, String meetingPoint) {
		this.state = state;
		this.city = city;
		this.neighborhood = neighborhood;
		this.street = street;
		this.meetingPoint = meetingPoint;
	}
	
	public LocationDTO(Location Entity) {
		state = Entity.getState();
		city = Entity.getCity();
		neighborhood = Entity.getNeighborhood();
		street = Entity.getStreet();
		meetingPoint = Entity.getMeetingPoint();
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getMeetingPoint() {
		return meetingPoint;
	}

	public void setMeetingPoint(String meetingPoint) {
		this.meetingPoint = meetingPoint;
	}
	
	
	
}

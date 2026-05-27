package com.comigo.vem.entities;

import jakarta.persistence.Embeddable;

@Embeddable
public class Location {
	
	private String state;
	private String city;
	private String neighborhood;
	private String street;
	private String meetingPoint;
	
	public Location() {
	}

	public Location(String state, String city, String neighborhood, String street, String meetingPoint) {
		this.state = state;
		this.city = city;
		this.neighborhood = neighborhood;
		this.street = street;
		this.meetingPoint = meetingPoint;
	}

	public String getState() {
		return state;
	}

	public String getCity() {
		return city;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public String getStreet() {
		return street;
	}

	public String getMeetingPoint() {
		return meetingPoint;
	}

	
	
}

package com.comigo.vem.DTO;

import com.comigo.vem.entities.Address;

public class AddressDTO {
	
	private Long id;
	private String city;
	private String neighborhood;
	private String street;
	private String number;
	private String complement;
	
	public AddressDTO() {
	}

	public AddressDTO(Long id, String city, String neighborhood, String street, String number, String complement) {
		this.id = id;
		this.city = city;
		this.neighborhood = neighborhood;
		this.street = street;
		this.number = number;
		this.complement = complement;
	}
	
	public AddressDTO(Address entity) {
		this.id = entity.getId();
		this.city = entity.getCity();
		this.neighborhood = entity.getNeighborhood();
		this.street = entity.getStreet();
		this.number = entity.getNumber();
		this.complement = entity.getComplement();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}
}

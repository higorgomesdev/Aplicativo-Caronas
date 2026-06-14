package com.comigo.vem.DTO;

import com.comigo.vem.entities.User;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UserPutDTO {
	
	private Long id;
	@NotBlank(message = "campo obrigatorio")
	private String name;
	@NotBlank(message = "campo obrigatorio")
	private String phone;
	private String photoUrl;
	
	@NotNull(message = "Endereço obrigatorio")
	private AddressDTO address;

	
	public UserPutDTO() {
	}
	
	public UserPutDTO(Long id, String name, String phone, String photoUrl, AddressDTO address) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.photoUrl = photoUrl;
		this.address = address;
	}

	public UserPutDTO(User entity) {
		id = entity.getId();
		name = entity.getName();
		phone = entity.getPhone();
		photoUrl = entity.getPhotoUrl();
		address = new AddressDTO(entity.getAddress());
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public AddressDTO getAddress() {
		return address;
	}

	public void setAddress(AddressDTO address) {
		this.address = address;
	}

}

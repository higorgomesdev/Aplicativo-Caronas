package com.comigo.vem.DTO;

import java.util.ArrayList;
import java.util.List;

import com.comigo.vem.entities.Role;
import com.comigo.vem.entities.User;

public class UserPutDTO {
	
	private Long id;
	private String name;
	private String phone;
	private String photoUrl;
	
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

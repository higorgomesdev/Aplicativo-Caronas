package com.comigo.vem.DTO;

import java.util.ArrayList;
import java.util.List;

import com.comigo.vem.entities.Role;
import com.comigo.vem.entities.User;

public class UserCreatedDTO {
	
	private Long id;
	private String cpf;
	private String name;
	private String email;
	private String birthDate;
	private String phone;
	private String password;
	private String photoUrl;
	
	private AddressDTO address;
	
	private List<RoleDTO> roles = new ArrayList<>();
	
	public UserCreatedDTO() {
	}

	public UserCreatedDTO(Long id, String cpf, String name, String email, String birthDate, String phone,
			String password, String photoUrl, AddressDTO address, List<RoleDTO> roles) {
		this.id = id;
		this.cpf = cpf;
		this.name = name;
		this.email = email;
		this.birthDate = birthDate;
		this.phone = phone;
		this.password = password;
		this.photoUrl = photoUrl;
		this.address = address;
		this.roles = roles;
	}
	
	public UserCreatedDTO(User entity) {
		id = entity.getId();
		cpf = entity.getCpf();
		name = entity.getName();
		email = entity.getEmail();
		birthDate = entity.getBirthDate();
		phone = entity.getPhone();
		photoUrl = entity.getPhotoUrl();
		address = new AddressDTO(entity.getAddress());
		for(Role r : entity.getRoles()) {
			roles.add(new RoleDTO(r));
		}	
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public List<RoleDTO> getRoles() {
		return roles;
	}
}

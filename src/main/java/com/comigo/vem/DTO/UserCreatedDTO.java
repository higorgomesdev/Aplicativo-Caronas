package com.comigo.vem.DTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.comigo.vem.entities.Role;
import com.comigo.vem.entities.User;
import com.comigo.vem.validations.Adult;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserCreatedDTO {
	
	private Long id;
	@Size(min = 11, max = 11, message = "CPF invalido")
	@NotBlank(message = "Campo Obrigatorio")
	private String cpf;
	@NotBlank(message = "Campo Obrigatorio")
	private String name;
	@Email(message = "email Invalido")
	private String email;
	@PastOrPresent(message = "A data deve ser uma data passada")
	@NotNull(message = "Campo Obrigatorio")
	@Adult(minAge = 16)
	private LocalDate birthDate;
	@NotBlank(message = "Campo obrigatorio")
	private String phone;
	@NotBlank(message = "A senha é obrigatória")
	@Size(min = 8, max = 50, message = "A senha deve ter entre 8 e 50 caracteres")
	@Pattern(
	    regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$",
	    message = "A senha deve conter letra maiúscula, minúscula e número"
	)
	private String password;
	private String photoUrl;
	@NotNull
	private AddressDTO address;
	
	private List<RoleDTO> roles = new ArrayList<>();
	
	public UserCreatedDTO() {
	}

	public UserCreatedDTO(Long id, String cpf, String name, String email, LocalDate birthDate, String phone,
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

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
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

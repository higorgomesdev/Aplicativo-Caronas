package com.comigo.vem.DTO;

import com.comigo.vem.entities.User;
import com.comigo.vem.projections.UserProjection;

public class UserResponseMinDTO {
	
	private Long id;
	private String name;
	private String photoUrl;
	
	public UserResponseMinDTO() {
	}

	public UserResponseMinDTO(Long id, String name, String photoUrl) {
		this.id = id;
		this.name = name;
		this.photoUrl = photoUrl;
	}
	
	public UserResponseMinDTO(UserProjection projection) {
		id = projection.getId();
		name = projection.getName();
		photoUrl = projection.getPhotoUrl();
	}
	
	public UserResponseMinDTO(User entity) {
		id = entity.getId();
		name = entity.getName();
		photoUrl = entity.getPhotoUrl();
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

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	
	
}

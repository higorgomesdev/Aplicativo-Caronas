package com.comigo.vem.DTO;

import com.comigo.vem.entities.Role;

public class RoleDTO {
	
	private Long id;
	private String authority;
	
	public RoleDTO() {
	}
	
	public RoleDTO(Long id, String authority) {
		super();
		this.id = id;
		this.authority = authority;
	}
	
	public RoleDTO(Role entity) {
		this.id = entity.getId();
		this.authority = entity.getAuthority();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
}

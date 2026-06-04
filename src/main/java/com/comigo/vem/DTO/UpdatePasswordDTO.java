package com.comigo.vem.DTO;

public class UpdatePasswordDTO {
	
	private String currentPassword;
	private String newPassword;
	
	public UpdatePasswordDTO() {
	}

	public UpdatePasswordDTO(String currentPassword, String newPassword) {
		this.currentPassword = currentPassword;
		this.newPassword = newPassword;
	}

	public String getCurrentPassword() {
		return currentPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}
}

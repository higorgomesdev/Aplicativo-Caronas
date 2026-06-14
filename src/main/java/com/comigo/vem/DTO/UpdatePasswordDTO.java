package com.comigo.vem.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UpdatePasswordDTO {
	
	private String currentPassword;
	@NotBlank(message = "A senha é obrigatória")
	@Size(min = 8, max = 50, message = "A senha deve ter entre 8 e 50 caracteres")
	@Pattern(
	    regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$",
	    message = "A senha deve conter letra maiúscula, minúscula e número"
	)
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

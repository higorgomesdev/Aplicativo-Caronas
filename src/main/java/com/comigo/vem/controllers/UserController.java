package com.comigo.vem.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.comigo.vem.DTO.DriverDataDTO;
import com.comigo.vem.DTO.UpdatePasswordDTO;
import com.comigo.vem.DTO.UserCreatedDTO;
import com.comigo.vem.DTO.UserPutDTO;
import com.comigo.vem.DTO.UserResponseCreatedDriverDTO;
import com.comigo.vem.DTO.UserResponseDTO;
import com.comigo.vem.DTO.UserResponseMinDTO;
import com.comigo.vem.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@PostMapping
	public ResponseEntity<UserResponseDTO> newUser(@Valid @RequestBody UserCreatedDTO dto){
		UserResponseDTO responseUser = service.createdUser(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		
		return ResponseEntity.created(uri).body(responseUser);
	}
	
	@PreAuthorize("hasAnyRole('PASSENGER', 'DRIVER')")
	@GetMapping(value = "/me")
	public ResponseEntity<UserResponseDTO> getMe(){
		return ResponseEntity.ok(service.getMe());
	}
	
	@PreAuthorize("hasAnyRole('PASSENGER', 'DRIVER')")
	@GetMapping(value = "/me/min")
	public ResponseEntity<UserResponseMinDTO> getMeMin(){
		return ResponseEntity.ok(service.getMeMin());
	}
	
	@PreAuthorize("hasAnyRole('PASSENGER', 'DRIVER')")
	@PutMapping
	public ResponseEntity<UserResponseDTO> updateUser(@Valid @RequestBody UserPutDTO dto){
		return ResponseEntity.ok(service.updateUser(dto));
	}
	
	@PreAuthorize("hasAnyRole('PASSENGER', 'DRIVER')")
	@PutMapping(value = "/newPassword")
	public ResponseEntity<Void> newPassword(@Valid @RequestBody UpdatePasswordDTO dto){
		service.updatePassword(dto);
		return ResponseEntity.noContent().build();
			
	}
	@PreAuthorize("hasAnyRole('PASSENGER')")
	@PutMapping(value = "/newDriver")
	public ResponseEntity<UserResponseCreatedDriverDTO> createdDriver(@Valid @RequestBody DriverDataDTO dto){
		return ResponseEntity.ok().body(service.createdDriver(dto));
	}
	
}

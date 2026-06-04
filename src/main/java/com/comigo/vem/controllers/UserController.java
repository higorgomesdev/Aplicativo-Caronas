package com.comigo.vem.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.comigo.vem.DTO.UserResponseDTO;
import com.comigo.vem.DTO.UserResponseMinDTO;
import com.comigo.vem.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@PostMapping
	public ResponseEntity<UserResponseDTO> newUser(@RequestBody UserResponseDTO dto){
		UserResponseDTO createdUser = service.createdUser(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		
		return ResponseEntity.created(uri).body(createdUser);
	}
	
	@GetMapping(value = "/me")
	public ResponseEntity<UserResponseDTO> getMe(){
		return ResponseEntity.ok(service.getMe());
	}
	
	@GetMapping(value = "/me/min")
	public ResponseEntity<UserResponseMinDTO> getMeMin(){
		return ResponseEntity.ok(service.getMeMin());
	}
	
}

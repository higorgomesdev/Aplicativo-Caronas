package com.comigo.vem.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.comigo.vem.DTO.BookingDTO;
import com.comigo.vem.services.BookingService;

@RestController
@RequestMapping(value = "/bookings")
public class BookingController {
	
	@Autowired
	private BookingService service;
	
	@PostMapping(value = "/{rideId}/seats")
	public ResponseEntity<BookingDTO> reservedSeats(@PathVariable(name = "rideId") Long rideId,@RequestParam Integer seats){
	BookingDTO dto = service.reservedSeats(rideId, seats); 
	
	URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
	
	
	return ResponseEntity.created(uri).body(dto);
	}

}

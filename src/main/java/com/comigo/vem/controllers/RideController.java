package com.comigo.vem.controllers;

import java.net.URI;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.comigo.vem.DTO.RideDTO;
import com.comigo.vem.DTO.RideMeDriverDTO;
import com.comigo.vem.DTO.RideMePassengerDTO;
import com.comigo.vem.services.RideService;

@RestController
@RequestMapping(value = "/rides")
public class RideController {
	
	@Autowired
	private RideService service;
	
	@GetMapping
	public ResponseEntity<Page<RideDTO>> findByRote(
			@RequestParam(name = "cityOrigin") String cityOrigin, 
			@RequestParam(name = "stateOrigin") String stateOrigin, 
			@RequestParam(name = "cityDestination") String cityDestination, 
			@RequestParam(name = "stateDestination") String stateDestination,
			@RequestParam(name = "date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date, Pageable pageable){
		
		Page<RideDTO> rides = service.findByRote(cityOrigin, stateOrigin, cityDestination, stateDestination, date, pageable);
		
		return ResponseEntity.ok(rides);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<RideDTO> findById(@PathVariable(name = "id") Long id){
		return ResponseEntity.ok(service.findById(id));
	}
	
	

	@PostMapping
	public ResponseEntity<RideDTO> createdRide(@RequestBody RideDTO dto) {
		dto = service.createdRide(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@GetMapping(value = "/me/rides/driver")
	public ResponseEntity<Page<RideMeDriverDTO>> meRidesDriver(Pageable pageable){
		return ResponseEntity.ok(service.meRidesDriver(pageable));
	}

	@GetMapping(value = "/me/rides/passenger")
	public ResponseEntity<Page<RideMePassengerDTO>> meRidesPassenger(Pageable pageable){
		return ResponseEntity.ok(service.meRidesPassenger(pageable));
	}

}


















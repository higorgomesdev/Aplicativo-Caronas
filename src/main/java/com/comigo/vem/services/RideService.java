package com.comigo.vem.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.comigo.vem.DTO.RideDTO;
import com.comigo.vem.entities.Ride;
import com.comigo.vem.repositories.RideRepository;

@Service
public class RideService {
	
	@Autowired
	private RideRepository repository;
	
	@Transactional(readOnly = true)
	public Page<RideDTO> findByRote(String cityOrigin, String stateOrigin, String cityDestination, 
			String stateDestination,LocalDate date, Pageable pageable){
		
		Instant startOfDay = date.atStartOfDay(ZoneId.systemDefault()).toInstant();
		Instant endOfDay = date.plusDays(1).atStartOfDay(ZoneId.systemDefault()).toInstant();
		
		Page<Ride> rides = repository.findByRote(cityOrigin.toUpperCase(), stateOrigin.toUpperCase(), cityDestination.toUpperCase(), 
			stateDestination.toUpperCase(), startOfDay, endOfDay, pageable);
		
		return rides.map(RideDTO::new);
	}
		
	}


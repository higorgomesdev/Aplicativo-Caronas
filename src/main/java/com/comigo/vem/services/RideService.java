package com.comigo.vem.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.comigo.vem.DTO.LocationDTO;
import com.comigo.vem.DTO.RideDTO;
import com.comigo.vem.DTO.RideMeDriverDTO;
import com.comigo.vem.entities.Location;
import com.comigo.vem.entities.Ride;
import com.comigo.vem.entities.User;
import com.comigo.vem.entities.enums.StatusBooking;
import com.comigo.vem.entities.enums.StatusRide;
import com.comigo.vem.repositories.BookingRespository;
import com.comigo.vem.repositories.RideRepository;
import com.comigo.vem.repositories.RoleRepository;

@Service
public class RideService {
	
	@Autowired
	private RideRepository repository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BookingRespository bookingRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Transactional(readOnly = true)
	public Page<RideDTO> findByRote(String cityOrigin, String stateOrigin, String cityDestination, 
			String stateDestination,LocalDate date, Pageable pageable){
		
		Instant startOfDay = date.atStartOfDay(ZoneId.systemDefault()).toInstant();
		Instant endOfDay = date.plusDays(1).atStartOfDay(ZoneId.systemDefault()).toInstant();
		
		Page<Ride> rides = repository.findByRote(cityOrigin.toUpperCase(), stateOrigin.toUpperCase(), cityDestination.toUpperCase(), 
			stateDestination.toUpperCase(), startOfDay, endOfDay, pageable);
		
		return rides.map(RideDTO::new);
	}
	
	@Transactional(readOnly = true)
	public RideDTO findById(Long id) {
		return new RideDTO(repository.findById(id).get());
	}
	

	
	@Transactional
	public RideDTO createdRide(RideDTO dto) {
		User user = userService.authenticated();
		if(user.getRoles().stream().noneMatch(p-> p.getAuthority().equals("ROLE_DRIVER"))) {
			// tratamento de exceção
		}
		
		Ride ride = new Ride();
		ride.setCapacity(dto.getCapacity());
		ride.setDepartureTime(dto.getDepartureTime());
		
		Location starting = toLocation(dto.getStarting());
				
		Location destination = toLocation(dto.getDestination());

		ride.setStartingLocation(starting);
		ride.setDestinationLocation(destination);
		ride.setDriver(user);
		ride.setPrice(dto.getPrice());	
		ride.setStatus(StatusRide.AVAILABLE);
		
		return new RideDTO(repository.save(ride));
	}
	
	public Page<RideMeDriverDTO> meRides(Pageable pageable){
		User user = userService.authenticated();
		Page<Ride> rides = repository.searchMeRidesDriver(user.getId(), pageable);
		return rides.map(p-> {
				Long totalPendingRequests = p.getBookings().stream().filter(x-> x.getStatus() == StatusBooking.PENDING).count();
				RideMeDriverDTO dto = new RideMeDriverDTO(p);
				dto.setTotalPendingRequests(totalPendingRequests);
				return dto;
			});
	}

	private Location toLocation(LocationDTO dto) {
		return new Location(dto.getState(), dto.getCity(), dto.getNeighborhood(),
				dto.getStreet(), dto.getMeetingPoint());
	}
	
	
	
	
	
}


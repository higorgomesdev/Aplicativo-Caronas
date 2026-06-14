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
import com.comigo.vem.DTO.RideMePassengerDTO;
import com.comigo.vem.entities.Location;
import com.comigo.vem.entities.Ride;
import com.comigo.vem.entities.Role;
import com.comigo.vem.entities.User;
import com.comigo.vem.entities.enums.StatusBooking;
import com.comigo.vem.entities.enums.StatusRide;
import com.comigo.vem.repositories.BookingRespository;
import com.comigo.vem.repositories.RideRepository;
import com.comigo.vem.repositories.RoleRepository;
import com.comigo.vem.services.exceptions.ResourceNotFoundException;
import com.comigo.vem.services.exceptions.RideCanceledException;
import com.comigo.vem.services.exceptions.RideFullException;
import com.comigo.vem.services.exceptions.UserDriverException;

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
		if(rides.isEmpty()) {
			throw new ResourceNotFoundException("Nenhuma viagem encontrada");
		}
		return rides.map(RideDTO::new);
	}
	
	@Transactional(readOnly = true)
	public RideDTO findById(Long id) {
		Ride ride = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Recurso não encontrado"));
		if(ride.getStatus() == StatusRide.CANCELLED) {
			throw new RideCanceledException("Carona Cancelada");
		}
		Integer bookingsAccepted = ride.getBookings().stream().filter(p-> p.getStatus() == StatusBooking.ACCEPTED).mapToInt(p-> p.getSeats()).sum();
		if(bookingsAccepted >= ride.getCapacity()) {
			throw new RideFullException("Carona lotada");
		}
		
		return  new RideDTO(ride);
	}
	

	
	@Transactional
	public RideDTO createdRide(RideDTO dto) {
		User user = userService.authenticated();
		Role role = roleRepository.searchRoleDriver();
		if(!user.hasRole(role)) {
			throw new UserDriverException("usuario não tem permição para esta ação");
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
	
	@Transactional(readOnly = true)
	public Page<RideMeDriverDTO> meRidesDriver(Pageable pageable){
		User user = userService.authenticated();
		Page<Ride> rides = repository.searchMeRidesDriver(user.getId(), pageable);
		return rides.map(p-> {
				Long totalPendingRequests = p.getBookings().stream().filter(x-> x.getStatus() == StatusBooking.PENDING).count();
				RideMeDriverDTO dto = new RideMeDriverDTO(p);
				dto.setTotalPendingRequests(totalPendingRequests);
				return dto;
			});
	}
	
	@Transactional(readOnly = true)
	public Page<RideMePassengerDTO> meRidesPassenger(Pageable pageable){
		User user = userService.authenticated();
		Page<Ride> rides = repository.searchMeRidesPassenger(user.getId(), pageable);
		if(rides.isEmpty()) {
			throw new ResourceNotFoundException("Nenhuma viagem");
		}
		return rides.map(p-> new RideMePassengerDTO(p));

	}
	
	
	
	

	private Location toLocation(LocationDTO dto) {
		return new Location(dto.getState(), dto.getCity(), dto.getNeighborhood(),
				dto.getStreet(), dto.getMeetingPoint());
	}
	
	
	
	
	
}


package com.comigo.vem.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.comigo.vem.DTO.BookingDTO;
import com.comigo.vem.DTO.RideDTO;
import com.comigo.vem.entities.Booking;
import com.comigo.vem.entities.Ride;
import com.comigo.vem.entities.User;
import com.comigo.vem.entities.enums.StatusBooking;
import com.comigo.vem.repositories.BookingRespository;
import com.comigo.vem.repositories.RideRepository;

@Service
public class RideService {
	
	@Autowired
	private RideRepository repository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BookingRespository bookingRepository;
	
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
	public BookingDTO reservedSeats(Long rideId, Integer seats) {
		Ride ride = repository.findById(rideId).get(); // futuro tratamento de exceção
		User user = userService.authenticated();
		

		///validando se o motorista não esta solicitando reserva na sua propria viagem
		if(user.getId().equals(ride.getDriver().getId())) {
			//tratamento de exceção 
		}
		

		/// validando se usuario ja não possui reserva na viagem
		boolean hasReservation = ride.getBookings().stream().anyMatch(p-> p.getUser().getId().equals(user.getId()));
		if(hasReservation) {
		
		}

		
		///pegando o numero de vagas ocupadas usando as reservas registradas na viagem
		Integer occupiedSeats = ride.getBookings().stream().filter(p-> p.getStatus() == StatusBooking.ACCEPTED).mapToInt(Booking::getSeats).sum();
		
		///validando se a vagas disponiveis para efetuar a reserva
		if((ride.getCapacity() - occupiedSeats) < seats) {
		}
		
		Booking booking = new Booking();
		booking.setInstantBooking(Instant.now());
		booking.setRide(ride);
		booking.setSeats(seats);
		booking.setStatus(StatusBooking.PENDING);
		booking.setUser(user);
		
		booking = bookingRepository.save(booking);
		
		
		return new BookingDTO(booking);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}


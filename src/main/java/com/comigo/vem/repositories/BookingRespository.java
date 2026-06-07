package com.comigo.vem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comigo.vem.entities.Booking;

@Repository
public interface BookingRespository extends JpaRepository<Booking, Long>{
}

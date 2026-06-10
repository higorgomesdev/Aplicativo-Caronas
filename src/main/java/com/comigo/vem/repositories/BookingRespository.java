package com.comigo.vem.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.comigo.vem.entities.Booking;

@Repository
public interface BookingRespository extends JpaRepository<Booking, Long>{
	
	@EntityGraph(attributePaths = "user")
	@Query("""
		    SELECT obj
		    FROM Booking obj
		    WHERE obj.ride.id = :rideId
		    ORDER BY
		        CASE
		            WHEN obj.status = com.comigo.vem.entities.enums.StatusBooking.PENDING THEN 1
		            WHEN obj.status = com.comigo.vem.entities.enums.StatusBooking.ACCEPTED THEN 2
		            WHEN obj.status = com.comigo.vem.entities.enums.StatusBooking.REJECTED THEN 3
		        END,
		        obj.instantBooking DESC
		""")
		Page<Booking> searchBookingsByRide(@Param("rideId") Long rideId, Pageable pageable);
}

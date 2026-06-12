package com.comigo.vem.repositories;

import java.time.Instant;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.comigo.vem.entities.Ride;

@Repository
public interface RideRepository extends JpaRepository<Ride, Long>{
	
	@EntityGraph(attributePaths = "driver")
	@Query("SELECT obj "
		    + "FROM Ride obj "
		    + "WHERE UPPER(obj.startingLocation.city) = :cityOrigin "
		    + "AND UPPER(obj.startingLocation.state) = :stateOrigin "
		    + "AND UPPER(obj.destinationLocation.city) = :cityDestination "
		    + "AND UPPER(obj.destinationLocation.state) = :stateDestination "
		    + "AND obj.departureTime >= :startOfDay AND obj.departureTime < :endOfDay")
	public Page<Ride> findByRote(@Param("cityOrigin") String cityOrigin, @Param("stateOrigin") String stateOrigin, @Param("cityDestination") String cityDestination, 
			@Param("stateDestination") String stateDestination, @Param("startOfDay") Instant startOfDay, @Param("endOfDay") Instant endOfDay, Pageable pageable);
	
	@EntityGraph(attributePaths = {"bookings", "driver", "driver.driverData"})
	@Query("SELECT DISTINCT obj "
			+ "FROM Ride obj "
			+ "WHERE obj.driver.id = :userId "
			+ "ORDER BY obj.departureTime")
	public Page<Ride> searchMeRidesDriver(@Param("userId") Long userId, Pageable pageable);
	
	
	
	
	
	
	
	/*SELECT
    TB_RIDE.STARTING_STATE,
    TB_RIDE.STARTING_CITY,
    TB_RIDE.DESTINATION_STATE,
    TB_RIDE.DESTINATION_CITY,
    TB_RIDE.DEPARTURE_TIME,
    TB_RIDE.STATUS,
    TB_RIDE.PRICE,
    TB_USER.ID,
    TB_USER.NAME
FROM TB_RIDE
INNER JOIN TB_BOOKING
    ON TB_BOOKING.RIDE_ID = TB_RIDE.ID
INNER JOIN TB_USER
    ON TB_RIDE.DRIVER_ID = TB_USER.ID
WHERE TB_BOOKING.PASSENGER_ID = 3*/

	@EntityGraph(attributePaths = "driver")
	@Query("SELECT obj "
			+ "FROM Ride obj "
			+ "JOIN obj.bookings b "
			+ "WHERE b.user.id = :userId "
			+ "ORDER BY obj.departureTime")
	public Page<Ride> searchMeRidesPassenger(@Param("userId") Long userId, Pageable pageable);
}

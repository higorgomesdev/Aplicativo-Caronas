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
}

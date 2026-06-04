package com.comigo.vem.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.comigo.vem.entities.User;
import com.comigo.vem.projections.UserProjection;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	@EntityGraph(attributePaths = {"roles"})
	public Optional<User> findByEmail(String email);
	
	@Query(nativeQuery = true, value = "SELECT obj.id, obj.name, obj.photo_url "
			+ "FROM TB_USER as obj "
			+ "WHERE obj.email = :email")
	public Optional<UserProjection> searcheMeMin(String email);
}

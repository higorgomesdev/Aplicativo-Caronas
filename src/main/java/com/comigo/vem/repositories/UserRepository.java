package com.comigo.vem.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comigo.vem.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	@EntityGraph(attributePaths = {"roles"})
	public Optional<User> findByEmail(String email);
}

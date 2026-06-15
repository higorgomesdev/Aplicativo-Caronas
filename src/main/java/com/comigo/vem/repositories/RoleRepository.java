package com.comigo.vem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.comigo.vem.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
	

	@Query("SELECT obj "
			+ "FROM Role obj "
			+ "WHERE obj.authority = 'ROLE_PASSENGER'")
	public Role searchRolePassenger();
	
	@Query("SELECT obj "
			+ "FROM Role obj "
			+ "WHERE obj.authority = 'ROLE_DRIVER'")
	public Role searchRoleDriver();
}

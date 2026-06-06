package com.comigo.vem.services;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.comigo.vem.DTO.DriverDataDTO;
import com.comigo.vem.DTO.UpdatePasswordDTO;
import com.comigo.vem.DTO.UserCreatedDTO;
import com.comigo.vem.DTO.UserPutDTO;
import com.comigo.vem.DTO.UserResponseCreatedDriverDTO;
import com.comigo.vem.DTO.UserResponseDTO;
import com.comigo.vem.DTO.UserResponseMinDTO;
import com.comigo.vem.entities.Address;
import com.comigo.vem.entities.DriverData;
import com.comigo.vem.entities.Role;
import com.comigo.vem.entities.User;
import com.comigo.vem.repositories.RoleRepository;
import com.comigo.vem.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService{
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
		return user;
	}
	
	protected User authenticated() {
		//Pega o usuario logado
	    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    
	    // Verificação de segurança: checa se está autenticado
	    if (authentication == null || !authentication.isAuthenticated()) {
	        throw new UsernameNotFoundException("User not authenticated");
	    }
	    
	    //extra as claims do usuario logado
	    try {
	        Jwt jwtPrincipal = (Jwt) authentication.getPrincipal();
	        String username = jwtPrincipal.getClaim("username");
	        
	        return repository.findByEmail(username)
	                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + username));
	    }
	    catch(ClassCastException e) {
	    	// Ocorre caso o principal não seja um JWT válido
	        throw new UsernameNotFoundException("Invalid token principal");
	    }
	}
	
	@Transactional
	public UserResponseDTO createdUser(UserCreatedDTO dto) {
		
		User user = new User();
		userCopy(dto, user);
		//--------criando role padrão
		Role role = roleRepository.searchRoleUser();
		user.getRoles().add(role);
		//----------------
		user = repository.save(user);

		return new UserResponseDTO(user);		
	}
	
	@Transactional(readOnly = true)
	public UserResponseDTO getMe () {
		return new UserResponseDTO(authenticated());
	}
	
	@Transactional(readOnly = true)
	public UserResponseMinDTO getMeMin () {
		String email = authenticated().getEmail();
		return new UserResponseMinDTO(repository.searcheMeMin(email).get());
	}
	
	@Transactional
	public UserResponseDTO updateUser(UserPutDTO dto) {
		User user = userCopyPut(dto, authenticated());
		
		return new UserResponseDTO(repository.save(user));
	}
	
	@Transactional
	public void updatePassword (UpdatePasswordDTO dto) {
		User user = authenticated();
		try {
		if(passwordEncoder.matches(dto.getCurrentPassword(), user.getPassword())) {
			String newPassword = passwordEncoder.encode(dto.getNewPassword());
			user.setPassword(newPassword);
			repository.save(user);
		} else {
			throw new IOException("Senha incorreta");		
			}
		}
		catch(IOException e) {
			e.getMessage();
		}
	}
	
	@Transactional
	public UserResponseCreatedDriverDTO createdDriver(DriverDataDTO dto) {
	
		User user = authenticated();
		Role role = roleRepository.searchRoleDriver();
		
		if(user.hasRole(role)) {
			return null; // futuro tratamento de exceção
		} 
		user.addRole(role);
		
		DriverData driverData = toDriverData(dto);
		
		user.setDriverData(driverData);

		return new UserResponseCreatedDriverDTO(repository.save(user));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Copia os dados do dto que recebe para uma entidade
	private User userCopy(UserCreatedDTO dto, User entity) {
		
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		entity.setBirthDate(dto.getBirthDate());
		entity.setCpf(dto.getCpf());
		entity.setPhone(dto.getPhone());
		entity.setPassword(passwordEncoder.encode(dto.getPassword()));
		entity.setPhotoUrl(dto.getPhotoUrl());
		//----------------------------------------------------
		Address address = new Address();
		address.setStreet(dto.getAddress().getStreet());
		address.setNumber(dto.getAddress().getNumber());
		address.setComplement(dto.getAddress().getComplement());
		address.setNeighborhood(dto.getAddress().getNeighborhood());
		address.setCity(dto.getAddress().getCity());
		
		
		entity.setAddress(address);
		
		return entity;
	}
	
		private static User userCopyPut(UserPutDTO dto, User entity) {
		
		entity.setName(dto.getName());
		entity.setPhone(dto.getPhone());
		
		//----------------------------------------------------
		Address address = new Address();
		address.setStreet(dto.getAddress().getStreet());
		address.setNumber(dto.getAddress().getNumber());
		address.setComplement(dto.getAddress().getComplement());
		address.setNeighborhood(dto.getAddress().getNeighborhood());
		address.setCity(dto.getAddress().getCity());
		
		
		entity.setAddress(address);
		
		return entity;
	}
		
		private DriverData toDriverData(DriverDataDTO dto) {
		    DriverData driverData = new DriverData();
		    driverData.setCnh(dto.getCnh());
		    driverData.setVehicleModel(dto.getVehicleModel());
		    driverData.setLicensePlate(dto.getLicensePlate());
		    driverData.setColor(dto.getColor());
		    driverData.setVehicleYear(dto.getVehicleYear());

		    return driverData;
		}
}


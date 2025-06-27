package com.marketplace.user.service;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.marketplace.user.data.dto.UserDTO;
import com.marketplace.user.data.form.UserForm;
import com.marketplace.user.entity.User;
import com.marketplace.user.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired 
	private PasswordEncoder passwordEncoder;
	
	
	@Autowired
	private UserRepository userRepository;

	public UserDTO createUser(UserForm form) {
		
		User newUser = buildUser(form);
		
		userRepository.save(newUser);
		
		return toDTO(newUser);
	}
	

	private User buildUser(UserForm form) {
		User newUser = new User();
		newUser.setEmail(form.getEmail());
		newUser.setPassword(passwordEncoder.encode(form.getPassword()));
		newUser.setCreatedAt(Instant.now());
		
		System.out.println(newUser.getPassword());
		
		
		return newUser;
	}
	
	
	private UserDTO toDTO(User newUser) {
	
		UserDTO userDTO = new UserDTO();
		userDTO.setId(newUser.getId());
		userDTO.setEmail(newUser.getEmail());
		
		return userDTO;
	}

}

package com.marketplace.user.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.marketplace.user.data.dto.UserDTO;
import com.marketplace.user.data.form.LoginForm;
import com.marketplace.user.data.form.UserForm;
import com.marketplace.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<UserDTO> create(@RequestBody UserForm form) {
		
		UserDTO newUser = userService.createUser(form);
		
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(newUser.getId())
				.toUri();
		
		return ResponseEntity.created(uri).body(newUser);
	}
	
	@PostMapping("/auth")
	public ResponseEntity<String> authenticate(@RequestBody LoginForm form) {
	
		return ResponseEntity.ok().body("");
		
	}
	

}

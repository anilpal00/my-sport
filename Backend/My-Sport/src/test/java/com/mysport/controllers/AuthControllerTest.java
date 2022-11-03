package com.mysport.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.mysport.payload.request.LoginRequest;
import com.mysport.repository.RoleRepository;
import com.mysport.repository.UserRepository;
import com.mysport.security.jwt.JwtUtils;

@ExtendWith(MockitoExtension.class)
class AuthControllerTest {

	@Mock
	AuthenticationManager authenticationManager;

	@Mock
	UserRepository userRepository;

	@Mock
	RoleRepository roleRepository;

	@Mock
	PasswordEncoder encoder;

	@Mock
	JwtUtils jwtUtils;
	@InjectMocks
	AuthController authController ;
	@Test
	void testAuthenticateUser() {
		LoginRequest loginRequest = new LoginRequest();
		loginRequest.setPassword("anil");
		loginRequest.setUsername("anil");
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken("anil", loginRequest.getPassword()));
		System.out.print("=====================Authentication authentication"+authentication);
		
	}

}

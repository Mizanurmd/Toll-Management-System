package com.toll.managemnt.sysem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toll.managemnt.sysem.dao.LoginRequest;
import com.toll.managemnt.sysem.models.User;
import com.toll.managemnt.sysem.services.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	 @Autowired
	    private AuthService authService;

	    @PostMapping("/register")
	    public ResponseEntity<?> register(@RequestBody User user) {
	        User newUser = authService.register(user);
	        return ResponseEntity.ok(newUser);
	    }

	    @PostMapping("/login")
	    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
	        User user = authService.authenticate(request.getUsername(), request.getPassword());
	        // Return JWT token
	        return ResponseEntity.ok("JWT Token");
	    }

	
}

package com.toll.managemnt.sysem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.toll.managemnt.sysem.models.User;
import com.toll.managemnt.sysem.repositories.UserRepository;

@Service
public class AuthService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User register(User user) {
        // Password encoding, role assignment, etc.
        return userRepository.save(user);
    }

    public User authenticate(String username, String password) {
        // JWT Token generation logic
        return userRepository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

}

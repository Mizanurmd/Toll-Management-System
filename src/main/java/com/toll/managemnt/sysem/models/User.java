package com.toll.managemnt.sysem.models;

import java.math.BigDecimal;
import java.util.List;

import com.toll.managemnt.sysem.enums.Role;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="user")
public class User {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String username;
	    private String email;
	    private String password;

	    @Enumerated(EnumType.STRING)
	    private Role role;

	    @OneToMany(mappedBy = "user")
	    private List<Vehicle> vehicles;
	    
	 // New field to store wallet balance
	    private BigDecimal walletBalance = BigDecimal.ZERO; // Initial balance set to 0

}

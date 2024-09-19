package com.toll.managemnt.sysem.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.toll.managemnt.sysem.models.User;
import com.toll.managemnt.sysem.models.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
	List<Vehicle> findByUser(User user);

}

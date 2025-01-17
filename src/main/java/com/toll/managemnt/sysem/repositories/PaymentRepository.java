package com.toll.managemnt.sysem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.toll.managemnt.sysem.models.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

}

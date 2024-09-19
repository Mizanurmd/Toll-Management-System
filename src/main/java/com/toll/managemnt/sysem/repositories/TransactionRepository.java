package com.toll.managemnt.sysem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.toll.managemnt.sysem.models.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>{

}

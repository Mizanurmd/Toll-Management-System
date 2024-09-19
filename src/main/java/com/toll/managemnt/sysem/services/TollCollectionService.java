package com.toll.managemnt.sysem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toll.managemnt.sysem.dao.TollTransactionRequest;
import com.toll.managemnt.sysem.models.Transaction;
import com.toll.managemnt.sysem.repositories.TransactionRepository;

@Service
public class TollCollectionService {
	@Autowired
    private TransactionRepository transactionRepository;

    public Transaction collectToll(TollTransactionRequest request) {
        // Calculate toll amount based on vehicle and toll plaza
        // Save transaction
        return transactionRepository.save(new Transaction());
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

}

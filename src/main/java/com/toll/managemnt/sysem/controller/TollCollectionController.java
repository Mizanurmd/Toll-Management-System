package com.toll.managemnt.sysem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toll.managemnt.sysem.dao.TollTransactionRequest;
import com.toll.managemnt.sysem.models.Transaction;
import com.toll.managemnt.sysem.services.TollCollectionService;

@RestController
@RequestMapping("/api/toll")
public class TollCollectionController {
	  @Autowired
	  private TollCollectionService tollCollectionService;

	    @PostMapping("/collect")
	    public ResponseEntity<?> processTollTransaction(@RequestBody TollTransactionRequest request) {
	        Transaction transaction = tollCollectionService.collectToll(request);
	        return ResponseEntity.ok(transaction);
	    }

	    @GetMapping("/history")
	    public ResponseEntity<List<Transaction>> getTollHistory() {
	        return ResponseEntity.ok(tollCollectionService.getAllTransactions());
	    }

}

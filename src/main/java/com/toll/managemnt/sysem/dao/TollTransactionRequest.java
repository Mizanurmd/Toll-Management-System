package com.toll.managemnt.sysem.dao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TollTransactionRequest {
	private Long vehicleId;
    private Long tollPlazaId;
    private BigDecimal amount;
    private LocalDateTime timestamp;

}

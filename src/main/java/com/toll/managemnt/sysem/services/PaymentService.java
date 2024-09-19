package com.toll.managemnt.sysem.services;

import com.toll.managemnt.sysem.dao.PaymentRequest;
import com.toll.managemnt.sysem.models.Payment;

public interface PaymentService {
	Payment processTollPayment(PaymentRequest request);
    Payment rechargeWallet(PaymentRequest request);

}

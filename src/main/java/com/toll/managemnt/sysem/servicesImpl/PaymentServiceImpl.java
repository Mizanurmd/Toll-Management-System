package com.toll.managemnt.sysem.servicesImpl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;

import com.toll.managemnt.sysem.dao.PaymentRequest;
import com.toll.managemnt.sysem.models.Payment;
import com.toll.managemnt.sysem.models.User;
import com.toll.managemnt.sysem.repositories.PaymentRepository;
import com.toll.managemnt.sysem.repositories.UserRepository;
import com.toll.managemnt.sysem.services.PaymentService;



public class PaymentServiceImpl implements PaymentService{

	@Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private UserRepository userRepository;

    
    @Override
    public Payment processTollPayment(PaymentRequest request) {
        // Fetch user from the request
        User user = userRepository.findById(request.getUserId()).orElse(null);

        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }

        // Process toll payment
        BigDecimal amount = request.getAmount();

        // Check if the user has enough balance (in case of prepaid wallets)
        if (user.getWalletBalance().compareTo(amount) < 0) {
            throw new IllegalArgumentException("Insufficient balance");
        }

        // Deduct the amount from user's wallet
        user.setWalletBalance(user.getWalletBalance().subtract(amount));
        userRepository.save(user);

        // Create payment record
        Payment payment = new Payment();
        payment.setUser(user);
       // payment.setAmount(amount);
        payment.setPaymentMethod(request.getPaymentMethod());
       // payment.setTimestamp(LocalDateTime.now());
       // payment.setStatus("SUCCESS");

        // Save the payment record
        return paymentRepository.save(payment);
    }

    @Override
    public Payment rechargeWallet(PaymentRequest request) {
        // Fetch user from the request
        User user = userRepository.findById(request.getUserId()).orElse(null);

        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }

        // Add amount to user's wallet
        BigDecimal amount = request.getAmount();
        user.setWalletBalance(user.getWalletBalance().add(amount));
        userRepository.save(user);

        // Create payment record for the recharge
        Payment payment = new Payment();
        payment.setUser(user);
       // payment.setAmount(amount);
        payment.setPaymentMethod(request.getPaymentMethod());
       // payment.setTimestamp(LocalDateTime.now());
      //  payment.setStatus("RECHARGE_SUCCESS");

        // Save the payment record
        return paymentRepository.save(payment);
    }


}

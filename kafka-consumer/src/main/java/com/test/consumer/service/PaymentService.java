package com.test.consumer.service;

import com.test.consumer.entity.Payment;
import com.test.consumer.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    public void savePayments(Payment payment){
        paymentRepository.save(payment);
    }
}

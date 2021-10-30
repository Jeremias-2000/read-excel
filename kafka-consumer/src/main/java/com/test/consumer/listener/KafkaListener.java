package com.test.consumer.listener;

import com.test.consumer.entity.Payment;
import com.test.consumer.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
class KafkaConsumer {

    @Autowired
    private PaymentService paymentService;

    @KafkaListener(topics = "kafka-example",groupId = "group_id",containerFactory = "kafkaListenerContainerFactory")
    public void consume(Payment payment){
        paymentService.savePayments(payment);
        System.out.println("Consumed payment: " + payment);
    }
}

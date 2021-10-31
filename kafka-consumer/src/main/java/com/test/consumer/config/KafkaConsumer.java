package com.test.consumer.config;

import com.test.consumer.entity.Payment;
import com.test.consumer.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @Autowired
    private PaymentService paymentService;

    @KafkaListener(topics = "kafka-example",groupId = "group_id",containerFactory = "kafkaListenerContainerFactory")
    public void consume(@Payload Payment payment){
        paymentService.savePayments(payment);
        System.out.println("consumed payment: "+ payment.toString());
    }
}

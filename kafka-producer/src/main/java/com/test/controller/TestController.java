package com.test.controller;

import com.test.entity.Payment;
import com.test.service.ReadExcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
    @Autowired
    private ReadExcel excel;
    @Autowired
    KafkaTemplate<String,Payment> kafkaTemplate;
    private static  final String TOPIC = "kafka-example";


    @GetMapping ("/test")
    public String test(){
        return "hello kafka";
    }
    @PostMapping("/read")
    public List<Payment> pymnts(){
        return excel.read();
    }
    @PostMapping("/kafka/publish")
    public String publish(){
        excel.read().forEach(payment -> {
            kafkaTemplate.send(TOPIC,payment);
        });
        return "Published successfully";
    }
}

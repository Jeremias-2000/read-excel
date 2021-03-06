package com.test.consumer.config;

import com.test.consumer.entity.Payment;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;

import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConsumerAwareListenerErrorHandler;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.messaging.MessageHeaders;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfiguration {



    @Bean
    public ConcurrentKafkaListenerContainerFactory<String,Payment> kafkaListenerContainerFactory(){
        ConcurrentKafkaListenerContainerFactory<String,Payment> factory =
                new ConcurrentKafkaListenerContainerFactory();
        factory.setConsumerFactory(paymentConsumerFactory());

        return factory;
    }

    @Bean
    public ConsumerFactory<String, Payment> paymentConsumerFactory(){
        Map<String,Object> config = new HashMap<>();

        JsonDeserializer<Payment> deserializer = new JsonDeserializer<>(Payment.class);
        deserializer.setRemoveTypeHeaders(false);
        deserializer.addTrustedPackages("*");
        deserializer.setUseTypeMapperForKey(true);

        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"127.0.0.1:9092");
        config.put(ConsumerConfig.GROUP_ID_CONFIG,"group_id");
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, deserializer);

        /*  Error Handling */
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, ErrorHandlingDeserializer.class);
        config.put(ErrorHandlingDeserializer.VALUE_DESERIALIZER_CLASS, JsonDeserializer.class.getName());
        //config.put(JsonDeserializer.TRUSTED_PACKAGES, "com.test.consumer.entity.*");


        return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(), deserializer);
    }




}

package com.live.kafka.cinemaProducer.producer;

import com.live.kafka.cinemaProducer.controller.CinemaDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import java.util.concurrent.CompletableFuture;

@Service
public class CinemaProducer {

    public static final Logger logger = LoggerFactory.getLogger(CinemaProducer.class);
    private final String topic;
    private final KafkaTemplate<String, CinemaDTO> kafkaTemplate;

    public CinemaProducer(@Value("${topic.name}") String topic, KafkaTemplate<String, CinemaDTO> kafkaTemplate) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
        kafkaTemplate.setDefaultTopic(topic);
    }

    public void send(CinemaDTO cinemaDTO){
        CompletableFuture<SendResult<String, CinemaDTO>> future =  kafkaTemplate.send(topic,cinemaDTO);
    }
}

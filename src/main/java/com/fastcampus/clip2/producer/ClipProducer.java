package com.fastcampus.clip2.producer;

import com.fastcampus.clip2.model.Animal;
import org.springframework.kafka.core.KafkaProducerException;
import org.springframework.kafka.core.KafkaSendCallback;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;


@Service
public class ClipProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final KafkaTemplate<String, Animal> JsonTemplate;

    public ClipProducer(KafkaTemplate<String,String> kafkaTemplate, KafkaTemplate<String, Animal> jsonTemplate){
        this.kafkaTemplate = kafkaTemplate;
        JsonTemplate = jsonTemplate;
    }

    public void async(String topic,String message){
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, message);
        future.addCallback(new KafkaSendCallback<>(){

            @Override
            public void onSuccess(SendResult<String, String> result) {
                System.out.println("Success to send Message ");
            }

            @Override
            public void onFailure(KafkaProducerException ex) {
                System.out.println("record "+ex);
            }
        });


    }

    public void async(String topic,Animal animal){
        JsonTemplate.send(topic,animal);
    }

    }

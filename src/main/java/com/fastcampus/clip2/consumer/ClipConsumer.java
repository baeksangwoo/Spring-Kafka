package com.fastcampus.clip2.consumer;

import com.fastcampus.clip2.model.Animal;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.adapter.ConsumerRecordMetadata;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ClipConsumer {

        @KafkaListener(id ="clip4-listener", topics = "clip4-listener")
        public void listen(String message,
                           @Header(KafkaHeaders.RECEIVED_TIMESTAMP) long timestamp,
                           @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
                           @Header(KafkaHeaders.OFFSET) long offset,
                           ConsumerRecordMetadata metadata){
            System.out.println("Listenr.offesets = "+metadata.offset()+
                    "partition = "+partition+
                    "timestamp = "+new Date(timestamp)+
                    "offesets = "+offset+
                    "Listener Message ="+message);
        }
        @KafkaListener(id="clip4-animal-listener", topics = "clip4-animal")
        public void listenAnimal(Animal animal){
            System.out.println("Animal= "+ animal);
        }
}

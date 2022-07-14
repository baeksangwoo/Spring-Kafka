package com.fastcampus.clip2;

import com.fastcampus.clip2.model.Animal;
import com.fastcampus.clip2.producer.ClipProducer;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.TopicDescription;
import org.apache.kafka.clients.admin.TopicListing;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;
import org.springframework.kafka.retrytopic.EndpointCustomizer;

import java.util.Collections;
import java.util.Map;

@SpringBootApplication
public class Clip2Application {

    public static void main(String[] args) {
        SpringApplication.run(Clip2Application.class, args);
    }

    @Bean
    public ApplicationRunner runner(ClipProducer clipProduce){
            return args -> {
                clipProduce.async("clip-animal",new Animal("puppy", 1 ));

            };
    }
}

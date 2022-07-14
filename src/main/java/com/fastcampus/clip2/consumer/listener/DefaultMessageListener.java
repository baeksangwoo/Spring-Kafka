package com.fastcampus.clip2.consumer.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.MessageListener;

public class DefaultMessageListener implements MessageListener<String,String> {


    @Override
    public void onMessage(ConsumerRecord<String, String> data) {
        System.out.println("Defalut Message Listener"+data.value());
    }
}

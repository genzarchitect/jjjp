package com.stackroute.bookingservice.services;
import com.stackroute.bookingservice.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    @Autowired

    private KafkaTemplate<String, Message> kafkaTemplate;

    private final static String TOPIC_NAME="Arena";
    public void sendMessage(Message message)
    {
        kafkaTemplate.send(TOPIC_NAME,message);
    }
}

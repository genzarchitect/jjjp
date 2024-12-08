package com.stackroute.service;


import com.stackroute.userDTO.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    @Autowired
    private KafkaTemplate<String, UserDTO> kafkaTemplate;


    public MessageService(KafkaTemplate<String, UserDTO> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    private final static String TOPIC_NAME = "game";
    public void sendMessage(UserDTO message)
    {
        kafkaTemplate.send(TOPIC_NAME,message);
        System.out.println("Send"+message);
    }



}

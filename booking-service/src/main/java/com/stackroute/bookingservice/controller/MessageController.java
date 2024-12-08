package com.stackroute.bookingservice.controller;

import com.stackroute.bookingservice.model.Message;
import com.stackroute.bookingservice.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api")
public class MessageController {
    @Autowired
    private MessageService service;

@PostMapping("/sendmessage")
public String sendMessage(@RequestBody Message message)
{
    service.sendMessage(message);
    System.out.println("Successfully published='" + message +"'message");
    return "Successfully published the animal='" + message +"'message";
}
}
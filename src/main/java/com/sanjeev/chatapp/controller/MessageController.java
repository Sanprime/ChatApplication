package com.sanjeev.chatapp.controller;

import com.sanjeev.chatapp.MessageService;
import com.sanjeev.chatapp.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class MessageController {

    @Autowired
    MessageService messageService;

    private List<Message> defaultMessages = new ArrayList<>();

    private List<Message> generatedDefaultMessages() {
        Message defaultMessage1 = Message.builder()
                .toUserId("1")
                .message("Hey!")
                .timeStamp(Date.from(Instant.now()))
                .build();
        Message defaultMessage2 = Message.builder()
                .toUserId("1")
                .message("How are you?")
                .timeStamp(Date.from(Instant.now()))
                .build();
        defaultMessages.add(defaultMessage1);
        defaultMessages.add(defaultMessage2);
        return defaultMessages;
    }

    @GetMapping("/messages/{userId}")
    public List<Message> getAllMessages(@PathVariable String userId) {
        return messageService.retrieveAllMessagesByUserId(userId);
    }

    @PostMapping("/message")
    public void newMessage(@RequestBody Message newMessage) throws IOException {
        messageService.sendNewMessage(newMessage);
    }
}

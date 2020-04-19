package com.sanjeev.chatapp;

import com.google.gson.Gson;
import com.sanjeev.chatapp.model.Message;
import com.sanjeev.chatapp.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class MessageService {

    @Autowired
    MessageRepository messageRepository;

    Jedis jedis = new Jedis();

    public void sendNewMessage(Message newMessage) throws IOException {
        Gson gson = new Gson();
        String json = gson.toJson(newMessage);
        jedis.lpush(newMessage.getToUserId(), json);
    }

    public List<Message> retrieveAllMessagesByUserId(String toUserId) {
        Gson gson = new Gson();
        List<String> messageObjectAsStringList = jedis.lrange(toUserId, 0, -1);
        List<Message> messageList = new ArrayList<>();
        for (String messageObjectAsString: messageObjectAsStringList) {
            messageList.add(gson.fromJson(messageObjectAsString, Message.class));
        }
        return messageList;
    }
}

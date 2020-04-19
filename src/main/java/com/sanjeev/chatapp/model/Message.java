package com.sanjeev.chatapp.model;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Builder
@AllArgsConstructor
@Data
@RedisHash("Message")
public class Message implements Serializable {
    @Id
    private String toUserId;

    private String message;
    private Date timeStamp;
}
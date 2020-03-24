package com.sanjeev.chatapp.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class Messages {
    String fromUser;
    String toUser;
    String message;
    Date timeStamp;
}
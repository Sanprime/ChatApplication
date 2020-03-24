package com.sanjeev.chatapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class User {
   String username;
   String password; 
}
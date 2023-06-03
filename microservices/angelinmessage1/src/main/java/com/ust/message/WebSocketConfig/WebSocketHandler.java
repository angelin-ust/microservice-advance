package com.ust.message.WebSocketConfig;

import org.springframework.web.socket.CloseStatus;
//WebSocketHandler.java
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class WebSocketHandler extends TextWebSocketHandler {
 private static Set<WebSocketSession> sessions = new HashSet<>();

 @Override
 public void afterConnectionEstablished(WebSocketSession session) throws Exception {
     sessions.add(session);
 }

 @Override
 protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
     String payload = message.getPayload();
     for (WebSocketSession s : sessions) {
         s.sendMessage(new TextMessage(payload));
     }
 }

 @Override
 public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
     sessions.remove(session);
 }
}


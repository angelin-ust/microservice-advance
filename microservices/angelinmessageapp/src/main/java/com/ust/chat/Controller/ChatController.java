package com.ust.chat.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.ust.chat.model.Message;
import com.ust.chat.repository.MessageRepository;

@Controller
public class ChatController {

    @Autowired
    private MessageRepository messageRepository;

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public Message handleChatMessage(Message message) {
        // Save the message to the database
        messageRepository.save(message);

        // Broadcast the message to all subscribers
        return message;
    }
}

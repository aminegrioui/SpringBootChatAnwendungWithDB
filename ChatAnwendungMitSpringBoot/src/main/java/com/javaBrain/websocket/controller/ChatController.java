package com.javaBrain.websocket.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.javaBrain.websocket.model.ChatMessage;
import com.javaBrain.websocket.model.ContentOfChatMessage;
import com.javaBrain.websocket.service.ChatService;

@Controller
public class ChatController {
	@Autowired
	private ChatService service;
	private static final Logger logger = LoggerFactory.getLogger(ChatController.class);
	@MessageMapping("/chat.register")
	@SendTo("/topic/public")
	public ChatMessage register(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
	
		headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
		return chatMessage;
	}

	@MessageMapping("/chat.send")
	@SendTo("/topic/public")
	public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
		
		
		ContentOfChatMessage message=new ContentOfChatMessage(chatMessage.getContent(), chatMessage.getSender());
		logger.info( "######### Message From ContentOfChatMessage #####");
		logger.info( message.getSender());
		logger.info( message.getContent());
		
		service.save(message);
		return chatMessage;
	}
	@GetMapping("/nachrichten")
	public String schowAlleNachrichten(Model model) {
		List<ContentOfChatMessage> list=service.getAllNahcricht();
		model.addAttribute("list",list);
		return "table";
	}
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable(name ="id") long id) {
		service.delete(id);
		return "redirect:/nachrichten";
	}
	@RequestMapping("/conversation")
	public String getConversation() {
		
		return "redirect:/";
	}
}

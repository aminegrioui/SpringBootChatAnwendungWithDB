package com.javaBrain.websocket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaBrain.websocket.model.ContentOfChatMessage;
import com.javaBrain.websocket.repository.MessageRepository;

@Service
public class ChatService {

	@Autowired
	private MessageRepository repository;
	
	public void save(ContentOfChatMessage contentOfChatMessage) {
		repository.save(contentOfChatMessage);
	}
	public List<ContentOfChatMessage> getAllNahcricht(){
		return repository.findAll();
	}
	public void delete(long id) {
		repository.deleteById(id);
	}
}

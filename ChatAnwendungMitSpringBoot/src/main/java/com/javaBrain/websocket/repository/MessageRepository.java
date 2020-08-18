package com.javaBrain.websocket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaBrain.websocket.model.ContentOfChatMessage;



public interface MessageRepository extends JpaRepository<ContentOfChatMessage, Long>{

}

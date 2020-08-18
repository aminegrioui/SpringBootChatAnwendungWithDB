package com.javaBrain.websocket.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
public class ContentOfChatMessage {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	public long id;
	private String content;
	private String sender;
	public ContentOfChatMessage(){
		
	}
	public ContentOfChatMessage(String content, String sender){
		this.content=content;
		this.sender=sender;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	
}

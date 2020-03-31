package com.kevin.bora.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.kevin.bora.domain.Chat;
import com.kevin.bora.domain.Message;
import com.kevin.bora.repositories.ChatRepository;
import com.kevin.bora.repositories.MessageRepository;
import com.kevin.bora.services.exceptions.DataIntegrityException;
import com.kevin.bora.services.exceptions.ObjectNotFoundException;

@Service
public class MessageService {

	@Autowired
	private MessageRepository repo;
	@Autowired
	private ChatRepository chatRepository;
	@Autowired
	private ChatService chatService;
	
	public Message find( Integer id ) {
		Optional<Message> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object not find! Id: " + id + ", Type: " + Message.class.getName()));
	}
	
	public void delete(Integer id) {
		find(id);
		try {
		repo.deleteById(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("It's impossible to delete a category with events");
		}
	}

	public Message insert(Integer chat_id, Integer sender_id, String msg) {
		Chat obj = chatService.find(chat_id);
		Message newMsg = new Message(null, sender_id, msg, obj);
		obj.getMessages().add(newMsg);
		repo.save(newMsg);
		chatRepository.save(obj);
		return newMsg;
	}
}
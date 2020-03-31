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
	
	public Message find( Integer id ) {
		Optional<Message> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object not find! Id: " + id + ", Type: " + Message.class.getName()));
	}
	
	public Message insert(Message obj) {
		obj.setId(null);
		return repo.save(obj);
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

	public Message insert(Chat obj, Integer sender_id, String msg) {
		Message newMsg = new Message(null, sender_id, msg);
		obj.getMessages().add(newMsg);
		repo.save(newMsg);
		chatRepository.save(obj);
		return newMsg;
	}
}
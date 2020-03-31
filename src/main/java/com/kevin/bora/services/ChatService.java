package com.kevin.bora.services;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.kevin.bora.domain.Chat;
import com.kevin.bora.dto.ChatNewDTO;
import com.kevin.bora.repositories.ChatRepository;
import com.kevin.bora.services.exceptions.DataIntegrityException;
import com.kevin.bora.services.exceptions.ObjectNotFoundException;

@Service
public class ChatService {

	@Autowired
	private ChatRepository repo;

	public Chat find(Integer id) {
		Optional<Chat> obj = repo.findById(id);
		return obj.orElseThrow(
				() -> new ObjectNotFoundException("Object not find! Id: " + id + ", Type: " + Chat.class.getName()));
	}

	public Chat insert(ChatNewDTO objNewDto) {
		Chat newObj = new Chat(null);
		newObj.getLogins().addAll(Arrays.asList(objNewDto.getLogin1(), objNewDto.getLogin2(), objNewDto.getLogin3(), objNewDto.getLogin4(), objNewDto.getLogin5()));
		return repo.save(newObj);
	}
/*
	public Chat update(Integer id, ChatDTO objDto) {
		Chat findObj = find(id);
		Chat obj = updateData(findObj, objDto.getSender(), objDto.getMessage());
		return repo.save(obj);
	}
*/
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("It's impossible to delete a chat with users");
		}
	}
/*

	public Chat findByMainPages(List<Login> logins) {
		List<Chat> chats = repo.findAll();
		for (int a = 0; a < chats.size(); a++) {
			if (chats.get(a).getMainPages() == logins) {
				return chats.get(a);
			}
		}
		throw new ObjectNotFoundException("Não existe chat com esses membros");
	}

	public boolean checkMainPagesInChat(List<Login> logins) {
		List<Chat> chats = repo.findAll();
		for (int a = 0; a < chats.size(); a++) {
			if (chats.get(a).getMainPages() == logins) {
				return true;
			}
		}
		return false;
	} 
	*/
}

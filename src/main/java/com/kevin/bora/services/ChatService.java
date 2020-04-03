package com.kevin.bora.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.kevin.bora.domain.Chat;
import com.kevin.bora.domain.User;
import com.kevin.bora.dto.ChatDTO;
import com.kevin.bora.dto.ChatNewDTO;
import com.kevin.bora.repositories.ChatRepository;
import com.kevin.bora.services.exceptions.DataIntegrityException;
import com.kevin.bora.services.exceptions.ObjectNotFoundException;

@Service
public class ChatService {

	@Autowired
	private ChatRepository repo;
	@Autowired
	private UserService userService;

	public Chat find(Integer id) {
		Optional<Chat> obj = repo.findById(id);
		return obj.orElseThrow(
				() -> new ObjectNotFoundException("Object not find! Id: " + id + ", Type: " + Chat.class.getName()));
	}

	public Chat insert(ChatNewDTO objDto) {
		Chat newObj = new Chat(null);
		newObj.getUsers().add(userService.find(objDto.getUserId1()));
		newObj.getUsers().add(userService.find(objDto.getUserId2()));
		if(objDto.getUserId3() != null) {
			newObj.getUsers().add(userService.find(objDto.getUserId3()));
		}
		if(objDto.getUserId4() != null) {
			newObj.getUsers().add(userService.find(objDto.getUserId4()));
		}
		if(objDto.getUserId5() != null) {
			newObj.getUsers().add(userService.find(objDto.getUserId5()));
		}		
		return repo.save(newObj);
	}

	public Chat update(Integer id, ChatDTO objDto) {
		Chat obj = find(id);
		User user = userService.find(objDto.getUserId1());
		for(int a = 0; a < obj.getUsers().size(); a++) {
			if(user == obj.getUsers().get(a)) {
				obj.getUsers().remove(a);
				return repo.save(obj);
			}
		}
		obj.getUsers().add(user);
		return repo.save(obj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("It's impossible to delete a chat with users");
		}
	}
}

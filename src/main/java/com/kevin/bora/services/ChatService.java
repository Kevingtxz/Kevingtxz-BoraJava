package com.kevin.bora.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.kevin.bora.domain.Chat;
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
		List<Integer> listId = new ArrayList<>();
		listId.addAll(Arrays.asList(objDto.getUserId1(), objDto.getUserId2(), objDto.getUserId3(), objDto.getUserId4(), objDto.getUserId5()));
		newObj.getUsers().addAll(userService.findUsersById(listId));
		return repo.save(newObj);
	}

	public Chat update(Integer id, ChatDTO objDto) {
		Chat obj = find(id);
		if(objDto.isPost()) {
			obj.getUsers().add(userService.find(objDto.getUserId1()));
		}else {
			obj.getUsers().remove(userService.find(objDto.getUserId1()));
		}
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

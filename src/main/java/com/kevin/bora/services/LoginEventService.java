package com.kevin.bora.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.kevin.bora.domain.LoginEvent;
import com.kevin.bora.dto.LoginDTO;
import com.kevin.bora.repositories.LoginEventRepository;
import com.kevin.bora.services.exceptions.DataIntegrityException;
import com.kevin.bora.services.exceptions.ObjectNotFoundException;

@Service
public class LoginEventService {

	@Autowired
	private LoginEventRepository repo;
	
	public LoginEvent find( Integer id ) {
		Optional<LoginEvent> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object not find! Id: " + id + ", Type: " + LoginEvent.class.getName()));
	}
	
	public LoginEvent insert(LoginEvent obj) {
		obj.setId(null);
		return repo.save(obj);
	}
		
	public LoginEvent update(LoginDTO objDto, Integer id) {
		LoginEvent newObj = find(id);
		updataData(newObj, objDto);
		return repo.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
		repo.deleteById(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("É impossível deletar um Login com Evento");
		}
	}
	/*
	public List<LoginEvent> findAll(){
		return repo.findAll();
	}
	
	public Page<LoginEvent> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public LoginEvent fromDTO(LoginEventDTO objDto) {
		return new LoginEvent(objDto.getId(), objDto.getName());
	}
	
	*/
	public void updataData(LoginEvent obj, LoginDTO objDto) {
		if(objDto.getNickName() != null) {
			obj.setNickName(objDto.getNickName());
		}
		if(objDto.getNotes() != null) {
			obj.setNotes(objDto.getNotes());
		}
		if(objDto.getPassword() != null) {
			obj.setPassword(objDto.getPassword());
		}
	}
}










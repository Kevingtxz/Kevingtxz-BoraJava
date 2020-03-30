package com.kevin.bora.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kevin.bora.domain.Login;
import com.kevin.bora.dto.LoginDTO;
import com.kevin.bora.repositories.LoginRepository;
import com.kevin.bora.services.exceptions.ObjectNotFoundException;

@Service
public class LoginService {

	@Autowired
	private LoginRepository repo;
	
	public Login find( Integer id ) {
		Optional<Login> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object not find! Id: " + id + ", Type: " + Login.class.getName()));
	}

	public Login updateFromDTO(LoginDTO objDto, Integer id) {
		Login obj = find(id);
		if(objDto.getNickName() != null) {
			obj.setNickName(objDto.getNickName());
		}
		if(objDto.getNotes() != null) {
			obj.setNotes(objDto.getNotes());
		}
		if(objDto.getPassword() != null) {
			obj.setPassword(objDto.getPassword());
		}
		return repo.save(obj);
	}
}
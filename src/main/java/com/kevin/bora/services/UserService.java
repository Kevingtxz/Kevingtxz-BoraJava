package com.kevin.bora.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.kevin.bora.domain.User;
import com.kevin.bora.dto.UserDTO;
import com.kevin.bora.repositories.UserRepository;
import com.kevin.bora.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public User find( Integer id ) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object not find! Id: " + id + ", Type: " + User.class.getName()));
	}
	
	public User insert(User obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public Page<User> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public User updateFromDTO(User obj, UserDTO objDto) {
		if(objDto.getEmail() != null) {
			obj.setEmail(objDto.getEmail());
		}
		if(objDto.getGender() != null) {
			obj.setGender(objDto.getGender());
		}
		if(objDto.getPermission() != null) {
			obj.setPermission(objDto.getPermission());
		}
		return repo.save(obj);
	}
}













package com.kevin.bora.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.kevin.bora.domain.User;
import com.kevin.bora.domain.enums.Permission;
import com.kevin.bora.dto.UserDTO;
import com.kevin.bora.dto.UserNewDTO;
import com.kevin.bora.repositories.UserRepository;
import com.kevin.bora.services.exceptions.DataIntegrityException;
import com.kevin.bora.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	@Autowired
	private NeighborhoodService neighborhoodService;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public Page<User> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

	public User find( Integer id ) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object not find! Id: " + id + ", Type: " + User.class.getName()));
	}
	
	public User insert(User obj) {
		obj.setId(null);
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

	public List<User> findUsersById(List<Integer> ids){
		List<User> users = new ArrayList<>();
		for(int a = 0; a < ids.size(); a++) {
			if(ids.get(a) != null) {
				users.add(find(ids.get(a)));
			}	
		}
		return users;
	}
	
	public User fromNewDTO(UserNewDTO objNewDto) {
		return new User(null, objNewDto.getName(), objNewDto.getLastName(), objNewDto.getBirth(), objNewDto.getGender(), Permission.toEnum(objNewDto.getPermissionId()), null, objNewDto.getNickName(), objNewDto.getEmail(), objNewDto.getPassword(), neighborhoodService.find(objNewDto.getNeighborhoodId()));
	}
}
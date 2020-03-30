package com.kevin.bora.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.kevin.bora.domain.LoginUser;
import com.kevin.bora.dto.LoginDTO;
import com.kevin.bora.repositories.LoginUserRepository;
import com.kevin.bora.services.exceptions.DataIntegrityException;
import com.kevin.bora.services.exceptions.ObjectNotFoundException;

@Service
public class LoginUserService {

	@Autowired
	private LoginUserRepository repo;
	
	public LoginUser find( Integer id ) {
		Optional<LoginUser> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object not find! Id: " + id + ", Type: " + LoginUser.class.getName()));
	}
	
	public LoginUser insert(LoginUser obj) {
		obj.setId(null);
		return repo.save(obj);
	}
		
	public LoginUser update(LoginDTO objDto, Integer id) {
		LoginUser newObj = find(id);
		updataData(newObj, objDto);
		return repo.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
		repo.deleteById(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("É impossível deletar um login de usuário com usuario");
		}
	}
	/*
	public List<LoginUser> findAll(){
		return repo.findAll();
	}
	
	public Page<LoginUser> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public LoginUser fromDTO(LoginUserDTO objDto) {
		return new LoginUser(objDto.getId(), objDto.getName());
	}
	
	*/
	public void updataData(LoginUser obj, LoginDTO objDto) {
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









